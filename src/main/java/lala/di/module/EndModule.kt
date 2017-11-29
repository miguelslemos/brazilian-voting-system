package lala.di.module

import dagger.Module
import dagger.Provides
import lala.Navigator
import lala.data.AppDataManager
import lala.ui.end.EndPresenter

/**
 * Created by miguellemos on 18/10/17.
 */
@Module
class EndModule {

    @Provides
    fun providerEndPresenter(appDataManager: AppDataManager, navigator: Navigator): EndPresenter {
        return EndPresenter(appDataManager, navigator)
    }
}
