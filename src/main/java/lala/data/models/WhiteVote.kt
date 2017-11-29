package lala.data.models

/**
 * Created by miguellemos on 30/10/17.
 */

class WhiteVote : AbsVote() {
    override fun createVote(candidate: Candidate?): Candidate {
        return Candidate("Branco", -1, "none", OfficeType.NONE)
    }
}
