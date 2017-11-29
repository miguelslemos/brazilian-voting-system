package lala.ui.confirmcadidate

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import javafx.scene.text.Text
import lala.App
import lala.data.models.AbsVote
import lala.data.models.Candidate
import lala.data.models.WhiteVote
import lala.di.component.ConfirmCandidateComponent
import lala.di.component.DaggerConfirmCandidateComponent
import lala.util.mvp.BaseView
import java.net.URL
import java.util.*

/**
 * Created by miguellemos on 24/10/17.
 */

class ConfirmCandidateView : IConfirmCandidateView, Initializable, BaseView<ConfirmCandidateComponent, IConfirmCandidateView, ConfirmCandidatePresenter>() {

    @FXML
    lateinit private var txtNumber: Text
    @FXML
    lateinit private var txtName: Text
    @FXML
    lateinit private var txtParty: Text

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        presenter.get()
    }

    override fun onCreate() {
    }

    override fun constructComponent(): ConfirmCandidateComponent? {
        return DaggerConfirmCandidateComponent.builder()
                .applicationComponent(App.applicationComponent)
                .build();
    }

    override fun displayCadidateInfo(cadidate: Candidate) {
        txtName.text = cadidate.name
        txtNumber.text = cadidate.code.toString()
        txtParty.text = cadidate.party
    }

    @FXML
    protected fun onConfirmClicked(event: ActionEvent) {
        presenter.nextStep(WhiteVote().createVote(null))

    }


}