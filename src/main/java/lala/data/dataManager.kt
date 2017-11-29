package lala.data

import lala.data.models.AbsVote
import lala.data.prefs.PreferencesHelper

/**
 * Created by miguellemos on 30/10/17.
 */
interface dataManager : PreferencesHelper {

    fun startElection()
    fun validateCPF(CPF : String)
    fun setCurrentCodeNumber(code: Int)
    fun getCandidateByCode(): AbsVote
}