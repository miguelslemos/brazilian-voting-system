package lala.di.component

import dagger.Component
import lala.di.module.ConfirmCandidateModule
import lala.ui.confirmcadidate.ConfirmCandidateView
import lala.util.mvp.scope.ViewScope

/**
 * Created by miguellemos on 18/10/17.
 */
@ViewScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ConfirmCandidateModule::class))
interface ConfirmCandidateComponent : BaseViewComponent<ConfirmCandidateView>
