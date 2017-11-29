package lala.di.component

import dagger.Component
import lala.di.module.ChooseCandidateModule
import lala.ui.choosecandidate.ChooseCandidateView
import lala.util.mvp.scope.ViewScope

/**
 * Created by miguellemos on 18/10/17.
 */
@ViewScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ChooseCandidateModule::class))
interface ChooseCandidateComponent : BaseViewComponent<ChooseCandidateView>
