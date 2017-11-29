package lala.ui.end

import lala.App
import lala.di.component.DaggerEndComponent
import lala.di.component.EndComponent
import lala.util.mvp.BaseView

/**
 * Created by miguellemos on 27/11/17.
 */

class EndView : IEndView, BaseView<EndComponent, IEndView, EndPresenter>() {

    override fun constructComponent(): EndComponent {
        return DaggerEndComponent.builder()
                .applicationComponent(App.applicationComponent)
                .build();
    }

    override fun onCreate() {
       presenter.goToStartScreen();
    }

}