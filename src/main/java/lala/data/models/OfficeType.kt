package lala.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by miguellemos on 24/10/17.
 */
enum class OfficeType private constructor(private val type: Int, val position: String) {
    @SerializedName("1")
    MAYOR(1, "Mayor"),
    @SerializedName("2")
    ASSEMBLYMAN(2, "Assemblyman"),
    @SerializedName("3")
    NONE(3, "None")
}