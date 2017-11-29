package lala.di.module

import dagger.Module
import dagger.Provides
import lala.Navigator
import lala.data.AppDataManager
import lala.ui.confirmcadidate.ConfirmCandidatePresenter

/**
 * Created by miguellemos on 18/10/17.
 */
@Module
class ConfirmCandidateModule {

    @Provides
    fun providerChooseCandidatePresenter(appDataManager: AppDataManager, navigator: Navigator): ConfirmCandidatePresenter {
        return ConfirmCandidatePresenter(appDataManager, navigator)
    }
}
