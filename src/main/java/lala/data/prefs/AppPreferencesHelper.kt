package lala.data.prefs

import com.google.gson.Gson
import lala.data.models.*
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by miguellemos on 18/10/17.
 */

@Singleton
class AppPreferencesHelper
@Inject
constructor(private val gson: Gson, private val onGoingVote: ArrayList<AbsVote>) : PreferencesHelper {
    lateinit var electionData: ElectionData;
    var election: Election? = null
    var currentCodeNumber: Int = Int.MIN_VALUE;

    override fun loadData() {
        val inputStream: InputStream = File("src/main/resources/data.json").inputStream()
        val reader = InputStreamReader(inputStream)
        electionData = this.gson.fromJson(reader, ElectionData::class.java);
    }

    override fun exportInitialVotes(): Votes {
        return election!!.votes
    }

    override fun changeElectionDuration(duration: Int) {
        this.election!!.durationTime = duration;
    }

    override fun isElectorAllowed(CPF: String): Boolean {
        val results = this.electionData.cpfAllowed.filter({ it == CPF })
        return results.isNotEmpty();
    }

    override fun getCurrentOfficeType(): Office {
        return electionData.offices[onGoingVote.size]
    }

    override fun addVote(vote: AbsVote) {
        onGoingVote.add(vote)
    }

    override fun shouldFinishSession(): Boolean {
        return onGoingVote.size === this.electionData.offices.size
    }
}
