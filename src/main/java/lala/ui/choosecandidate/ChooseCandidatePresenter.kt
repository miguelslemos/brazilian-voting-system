package lala.ui.choosecandidate

import javafx.event.ActionEvent
import javafx.scene.Node
import lala.Navigator
import lala.data.AppDataManager
import lala.util.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by miguellemos on 24/10/17.
 */
class ChooseCandidatePresenter @Inject
constructor(private val appDataManager: AppDataManager, private val navigator: Navigator) : BasePresenter<IChooseCandidateView>() {


    fun displayNumber(event: ActionEvent) = ((event.source as Node).userData as String)

    fun getCurrentOfficeType() = appDataManager.getCurrentOfficeType()

    fun goToConfirmCandidateScreen(codeNumber: Int) {
        appDataManager.setCurrentCodeNumber(codeNumber)
        navigator.toConfirmCandidate()
    }

}