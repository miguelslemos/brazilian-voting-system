package lala.di.component

import dagger.Component
import lala.di.module.StartViewModule
import lala.ui.start.StartView
import lala.util.mvp.scope.ViewScope

/**
 * Created by miguellemos on 18/10/17.
 */
@ViewScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(StartViewModule::class))
interface StartViewComponent : BaseViewComponent<StartView>
