package lala.ui.start

import lala.Navigator
import lala.data.AppDataManager
import lala.exception.ElectionAlreadyStartedException
import lala.exception.InvalidDurationTimeException
import lala.exception.MissingCandidateException
import lala.util.mvp.BasePresenter

import javax.inject.Inject

/**
 * Created by miguellemos on 18/10/17.
 */
class StartPresenter
@Inject
constructor(private val appDataManager: AppDataManager, private val navigator: Navigator) : BasePresenter<IStartView>() {

    fun startElection() {
        try {
            appDataManager.startElection()
            navigator.toLoadElector()
        } catch (mCE: MissingCandidateException) {
            mCE.printStackTrace()
        } catch (iDTE: InvalidDurationTimeException) {
            iDTE.printStackTrace()
        } catch (eASE: ElectionAlreadyStartedException) {
            eASE.printStackTrace()
        }
    }

    fun quitApp() {
        TODO()
    }

    fun loadCandidates() {
        appDataManager.loadData()
    }

    fun showDurationModal() {

    }

    fun exportResults() {

    }

}
