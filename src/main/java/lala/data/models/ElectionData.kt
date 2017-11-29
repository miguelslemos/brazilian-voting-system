package lala.data.models

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by miguellemos on 24/10/17.
 */

class ElectionData(@SerializedName("id") val id: String, @SerializedName("duration") val duration: Int, @SerializedName("cpfAllowed") val cpfAllowed: ArrayList<String>, @SerializedName("candidates") val candidate: ArrayList<Candidate>, @SerializedName("offices") val offices: ArrayList<Office>)