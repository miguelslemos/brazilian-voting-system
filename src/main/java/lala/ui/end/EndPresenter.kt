package lala.ui.end

import lala.Navigator
import lala.data.AppDataManager
import lala.util.mvp.BasePresenter
import java.util.*
import javax.inject.Inject
import kotlin.concurrent.timerTask

/**
 * Created by miguellemos on 27/11/17.
 */

class EndPresenter
@Inject
constructor(private val appDataManager: AppDataManager, private val navigator: Navigator) : BasePresenter<IEndView>() {

    fun goToStartScreen() {
        Timer().schedule(timerTask {
            navigator.toSettings()
        }, 5000)

    }

}