package lala.data.models


/**
 * Created by miguellemos on 03/10/17.
 */
class Candidate(val name: String, val code: Int, val party: String, val officeType: OfficeType) : AbsVote() {
    override fun createVote(candidate: Candidate?): Candidate {
        return candidate!!;
    }


}
