package io.github.jerrymatera.explore.data.models

import com.google.gson.annotations.SerializedName


data class EnglishDemonyms(
    @SerializedName("f")
    val f: String,
    @SerializedName( "m")
    val m: String
)