package lala.data.prefs

import lala.data.models.AbsVote
import lala.data.models.Office
import lala.data.models.Votes

/**
 * Created by miguellemos on 24/10/17.
 */
interface PreferencesHelper {
    fun loadData()
    fun exportInitialVotes(): Votes
    fun changeElectionDuration(duration: Int)
    fun isElectorAllowed(CPF: String): Boolean
    fun getCurrentOfficeType(): Office
    fun addVote(vote: AbsVote)
    fun shouldFinishSession(): Boolean
}