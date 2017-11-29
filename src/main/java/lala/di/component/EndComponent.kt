package lala.di.component

import dagger.Component
import lala.di.module.EndModule
import lala.ui.end.EndView
import lala.util.mvp.scope.ViewScope

/**
 * Created by miguellemos on 18/10/17.
 */
@ViewScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(EndModule::class))
interface EndComponent : BaseViewComponent<EndView>

