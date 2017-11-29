package lala.di.component

import dagger.Component
import lala.di.module.LoadElectorModule
import lala.di.module.StartViewModule
import lala.ui.loadelector.LoadElectorView
import lala.ui.start.StartView
import lala.util.mvp.scope.ViewScope

/**
 * Created by miguellemos on 18/10/17.
 */
@ViewScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(LoadElectorModule::class))
interface LoadElectorComponent : BaseViewComponent<LoadElectorView>
