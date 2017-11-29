package lala.ui.confirmcadidate

import lala.data.models.Candidate
import lala.util.mvp.BaseMvpView

/**
 * Created by miguellemos on 24/10/17.
 */
interface IConfirmCandidateView : BaseMvpView {
    fun displayCadidateInfo(cadidate: Candidate)
}