package lala.di.module

import dagger.Module
import dagger.Provides
import lala.Navigator
import lala.data.AppDataManager
import lala.ui.start.StartPresenter

/**
 * Created by miguellemos on 18/10/17.
 */
@Module
class StartViewModule {

    @Provides
    fun providerStartPresenter(appDataManager: AppDataManager, navigator: Navigator): StartPresenter {
        return StartPresenter(appDataManager, navigator)
    }
}
