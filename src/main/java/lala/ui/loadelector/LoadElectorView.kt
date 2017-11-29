package lala.ui.loadelector

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.TextField
import lala.App
import lala.di.component.DaggerLoadElectorComponent
import lala.di.component.LoadElectorComponent
import lala.util.mvp.BaseView
import java.net.URL
import java.util.*

/**
 * Created by miguellemos on 24/10/17.
 */
class LoadElectorView : ILoadElectorView, Initializable, BaseView<LoadElectorComponent, ILoadElectorView, LoadElectorPresenter>() {
    @FXML
    lateinit var userCPF: TextField;

    override fun onCreate() {
    }

    override fun constructComponent(): LoadElectorComponent {
        return DaggerLoadElectorComponent.builder()
                .applicationComponent(App.applicationComponent)
                .build();
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
       presenter.applyMaskToCPF(userCPF)
    }

    @FXML
    protected fun onNumberPressed(event: ActionEvent) {
        val result = presenter.displayNumber(event)
        userCPF.text += result;
    }

    @FXML
    protected fun onCleanClicked(event: ActionEvent) {
        userCPF.text = "";
    }

    @FXML
    protected fun onConfirmClicked(event: ActionEvent) {
        presenter.validateCPF(userCPF.text);
    }

}

