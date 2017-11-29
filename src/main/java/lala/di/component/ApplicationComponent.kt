package lala.di.component

/**
 * Created by miguellemos on 18/10/17.
 */

import dagger.Component
import lala.App
import lala.Navigator
import lala.data.AppDataManager
import lala.data.prefs.AppPreferencesHelper
import lala.di.module.ApplicationModule

import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(app: App)
    fun preferencesHelper(): AppPreferencesHelper
    fun navigator(): Navigator
    fun dataManager(): AppDataManager

}
