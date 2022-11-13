package io.github.jerrymatera.explore.data.models

import com.google.gson.annotations.SerializedName

data class Demonyms(
    @SerializedName("eng")
    val eng: EnglishDemonyms,
    @SerializedName("fra")
    val fra: FrenchDemonyms?
)