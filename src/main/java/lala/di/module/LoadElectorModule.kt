package lala.di.module

import dagger.Module
import dagger.Provides
import lala.Navigator
import lala.data.AppDataManager
import lala.ui.loadelector.LoadElectorPresenter

/**
 * Created by miguellemos on 18/10/17.
 */
@Module
class LoadElectorModule {

    @Provides
    fun providerChooseCandidatePresenter(appDataManager: AppDataManager, navigator: Navigator): LoadElectorPresenter {
        return LoadElectorPresenter(appDataManager, navigator)
    }
}
