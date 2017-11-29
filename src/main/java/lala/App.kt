package lala

import javafx.application.Application
import javafx.stage.Stage
import lala.di.component.ApplicationComponent
import lala.di.component.DaggerApplicationComponent
import lala.di.module.ApplicationModule

/**
 * Created by miguellemos on 18/10/17.
 */
class App : Application() {

    init {
        initDagger()
    }

    companion object {
        lateinit var applicationComponent: ApplicationComponent;
        @JvmStatic fun main(args: Array<String>) {
            launch(App::class.java, *args)
        }
    }

    private fun initDagger() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        applicationComponent.inject(this)
    }

    override fun start(primaryStage: Stage) {
        applicationComponent.navigator().toStart(primaryStage);
    }

}