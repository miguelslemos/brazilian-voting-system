package lala.ui.loadelector

import javafx.beans.value.ObservableValue
import javafx.event.ActionEvent
import javafx.scene.Node
import javafx.scene.control.TextField
import lala.Navigator
import lala.data.AppDataManager
import lala.exception.CPFNotAllowedException
import lala.exception.InvalidCPFException
import lala.util.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by miguellemos on 24/10/17.
 */
class LoadElectorPresenter @Inject
constructor(private val appDataManager: AppDataManager, private val navigator: Navigator) : BasePresenter<ILoadElectorView>() {

    fun displayNumber(event: ActionEvent) = ((event.source as Node).userData as String)

    fun validateCPF(CPF: String) {
        try {
            appDataManager.validateCPF(CPF)
            goToNextScreen()
        } catch (iCe: InvalidCPFException) {
            iCe.printStackTrace()
            //TODO call view interface
        } catch (cNAE: CPFNotAllowedException) {
            cNAE.printStackTrace()
            //TODO call view interface
        }

    }

    private fun goToNextScreen() {
        navigator.toChooseCandidate()
    }

    fun applyMaskToCPF(userCPF: TextField) {
        userCPF.lengthProperty().addListener { observableValue: ObservableValue<out Number>, number: Number, number2: Number ->
            val mascara = "###.###.###-##"
            val alphaAndDigits = userCPF.text.replace("[\\-\\.]".toRegex(), "")
            val resultado = StringBuilder()
            var i = 0
            var quant = 0

            if (number2.toInt() > number.toInt()) {
                if (userCPF.text.length <= mascara.length) {
                    while (i < mascara.length) {
                        if (quant < alphaAndDigits.length) {
                            if ("#" == mascara.substring(i, i + 1)) {
                                resultado.append(alphaAndDigits.substring(quant, quant + 1))
                                quant++
                            } else {
                                resultado.append(mascara.substring(i, i + 1))
                            }
                        }
                        i++
                    }
                    userCPF.text = resultado.toString()
                }
                if (userCPF.text.length > mascara.length) {
                    userCPF.text = userCPF.getText(0, mascara.length)
                }
            }
        }
    }
}
