package lala.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by miguellemos on 06/11/17.
 */
data class Office(@SerializedName("officeType") val office: OfficeType,
                  @SerializedName("numberSize") val numberSize: Int) {
}