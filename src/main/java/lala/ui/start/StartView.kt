package lala.ui.start

import javafx.event.ActionEvent
import javafx.fxml.FXML
import lala.App
import lala.di.component.DaggerStartViewComponent
import lala.di.component.StartViewComponent
import lala.util.mvp.BaseView

/**
 * Created by miguellemos on 18/10/17.
 */
class StartView : IStartView, BaseView<StartViewComponent, IStartView, StartPresenter>() {

    override fun onCreate() {
    }

    override fun constructComponent(): StartViewComponent {
        return DaggerStartViewComponent.builder()
                .applicationComponent(App.applicationComponent)
                .build();
    }

    @FXML
    protected fun onStartElectionClicked(event: ActionEvent) {
        presenter.startElection();

//        teste.App.instance.goToStartVote()

    }

    @FXML
    protected fun onQuitAppClicked(event: ActionEvent) {
//        teste.App.instance.quitApp()
        presenter.quitApp()

    }

    @FXML
    protected fun onElectionDurationClicked(event: ActionEvent) {
        presenter.showDurationModal()
//        DurationDialog().showAndWait()
    }

    @FXML
    protected fun onLoadCandidatesClicked(event: ActionEvent) {
        presenter.loadCandidates()
    }

    @FXML
    protected fun onExportResultClicked(event: ActionEvent) {
        presenter.exportResults()
    }
}
