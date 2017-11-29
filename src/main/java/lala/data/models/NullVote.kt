package lala.data.models

/**
 * Created by miguellemos on 30/10/17.
 */
class NullVote : AbsVote() {
    override fun createVote(candidate: Candidate?): Candidate {
        return Candidate("Null", 0, "none", OfficeType.NONE)
    }
}