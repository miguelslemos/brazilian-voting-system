package lala.data.models

import java.util.HashMap

/**
 * Created by miguellemos on 03/10/17.
 */
class Votes {
    var voteMap: HashMap<AbsVote, Int>
    init {
        this.voteMap = HashMap<AbsVote, Int>()
    }
}
