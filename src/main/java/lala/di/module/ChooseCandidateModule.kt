package lala.di.module

import dagger.Module
import dagger.Provides
import lala.Navigator
import lala.data.AppDataManager
import lala.ui.choosecandidate.ChooseCandidatePresenter

/**
 * Created by miguellemos on 18/10/17.
 */
@Module
class ChooseCandidateModule {

    @Provides
    fun providerChooseCandidatePresenter(appDataManager: AppDataManager, navigator: Navigator): ChooseCandidatePresenter {
        return ChooseCandidatePresenter(appDataManager, navigator)
    }
}
