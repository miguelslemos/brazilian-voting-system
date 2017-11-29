package lala.ui.confirmcadidate

import lala.Navigator
import lala.data.AppDataManager
import lala.data.models.AbsVote
import lala.data.models.Candidate
import lala.util.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by miguellemos on 24/10/17.
 */

class ConfirmCandidatePresenter
@Inject
constructor(private val appDataManager: AppDataManager, private val navigator: Navigator) : BasePresenter<IConfirmCandidateView>() {

    fun get() {

        var a = appDataManager.getCandidateByCode()
//        if(a as Candidate) {
//
//        }
        view.displayCadidateInfo(a as Candidate)
    }

    fun nextStep(vote: AbsVote) {
        appDataManager.addVote(vote);
        if (appDataManager.shouldFinishSession()) {
            navigator.toEnd()
        } else {
            navigator.toChooseCandidate()
        }

    }

}