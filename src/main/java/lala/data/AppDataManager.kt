package lala.data

import lala.data.models.*
import lala.data.prefs.AppPreferencesHelper
import lala.exception.*
import lala.util.validator.CPFValidator

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by miguellemos on 18/10/17.
 */

@Singleton
class AppDataManager @Inject
constructor(private val preferencesHelper: AppPreferencesHelper) : dataManager {

    override fun loadData() {
        preferencesHelper.loadData()
    }

    override fun exportInitialVotes(): Votes {
        return preferencesHelper.exportInitialVotes()
    }

    override fun changeElectionDuration(duration: Int) {
        preferencesHelper.changeElectionDuration(duration)
    }

    @Throws(MissingCandidateException::class, InvalidDurationTimeException::class, ElectionAlreadyStartedException::class)
    override fun startElection() {
        if (preferencesHelper.electionData.candidate.isEmpty()) {
            throw MissingCandidateException()
        } else if (preferencesHelper.electionData.duration < 1) {
            throw InvalidDurationTimeException()
        } else if (preferencesHelper.election != null && preferencesHelper.election!!.isOpen) {
            //should be never happend
            throw ElectionAlreadyStartedException()
        }
        preferencesHelper.election = Election.create {
            cadidates = preferencesHelper.electionData.candidate
            durationTime = preferencesHelper.electionData.duration
        }
    }

    @Throws(InvalidCPFException::class, CPFNotAllowedException::class)
    override fun validateCPF(CPF: String) {
        if (!CPFValidator.isValidCPF(CPF)) {
            throw InvalidCPFException()
        } else if (!isElectorAllowed(CPF)) {
            throw CPFNotAllowedException()
        }
    }

    override fun isElectorAllowed(CPF: String): Boolean {
        return preferencesHelper.isElectorAllowed(CPF)
    }

    override fun getCurrentOfficeType(): Office {
        return preferencesHelper.getCurrentOfficeType()
    }

    override fun setCurrentCodeNumber(code: Int) {
        preferencesHelper.currentCodeNumber = code;
    }

    override fun getCandidateByCode(): AbsVote {
        preferencesHelper.electionData.candidate.filter {
            it.code === preferencesHelper.currentCodeNumber
        }.forEach {
            return it
        }
        if (preferencesHelper.currentCodeNumber === Int.MAX_VALUE) {
            return WhiteVote().createVote(null)
        } else {
            return NullVote().createVote(null)
        }
    }

    override fun addVote(vote: AbsVote) {
        preferencesHelper.addVote(vote);
    }

    override fun shouldFinishSession(): Boolean {
        return preferencesHelper.shouldFinishSession();
    }
}
