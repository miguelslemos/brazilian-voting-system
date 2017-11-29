package lala.ui.choosecandidate

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import lala.App
import lala.data.models.Office
import lala.di.component.ChooseCandidateComponent
import lala.di.component.DaggerChooseCandidateComponent
import lala.util.mvp.BaseView
import java.net.URL
import java.util.*

/**
 * Created by miguellemos on 24/10/17.
 */

class ChooseCandidateView : IChooseCandidateView, Initializable, BaseView<ChooseCandidateComponent, IChooseCandidateView, ChooseCandidatePresenter>() {

    private var labelPosition: Int = 0;

    lateinit private var officeType: Office
    @FXML
    lateinit private var officeTypeLabel: Label
    @FXML
    lateinit private var input1: Label
    @FXML
    lateinit private var input2: Label
    @FXML
    lateinit private var input3: Label
    @FXML
    lateinit private var input4: Label
    @FXML
    lateinit private var input5: Label

    lateinit private var labels: ArrayList<Label>

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        labels = ArrayList<Label>(arrayListOf(input1, input2, input3, input4, input5))
        officeType = presenter.getCurrentOfficeType()
        officeTypeLabel.text = officeType.office.name
        labels.take(officeType.numberSize).forEach {
            it.isVisible = true
        }
    }

    override fun onCreate() { }

    override fun constructComponent(): ChooseCandidateComponent? {
        return DaggerChooseCandidateComponent.builder()
                .applicationComponent(App.applicationComponent)
                .build();
    }

    @FXML
    protected fun onNumberPressed(event: ActionEvent) {
        labels[labelPosition].text = presenter.displayNumber(event)
        labelPosition++
    }

    @FXML
    protected fun onCleanClicked(event: ActionEvent) {
//        userCPF.text = "";
        print("lala")
    }

    @FXML
    protected fun onWhiteClicked(event: ActionEvent) {
//        presenter.validateCPF(userCPF.text);
        print("lala")
    }

    @FXML
    protected fun onConfirmClicked(event: ActionEvent) {
        val sb: StringBuilder = StringBuilder()
        labels.take(officeType.numberSize).forEach {
            sb.append(it.text)
        }
        presenter.goToConfirmCandidateScreen(sb.toString().toInt())
    }


}

