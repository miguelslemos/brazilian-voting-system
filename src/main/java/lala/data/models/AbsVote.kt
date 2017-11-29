package lala.data.models

/**
 * Created by miguellemos on 30/10/17.
 */

abstract class AbsVote {
    abstract fun createVote(candidate: Candidate?): Candidate
}