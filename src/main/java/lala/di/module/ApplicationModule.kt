package lala.di.module

import dagger.Module
import dagger.Provides
import lala.App
import javax.inject.Singleton
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import lala.data.models.AbsVote
import lala.data.models.Office
import java.util.*


/**
 * Created by miguellemos on 18/10/17.
 */

@Module
class ApplicationModule(private val app: App) {

    @Provides
    fun providesApplication() = app

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideOnGoing() = ArrayList<AbsVote>()


}
