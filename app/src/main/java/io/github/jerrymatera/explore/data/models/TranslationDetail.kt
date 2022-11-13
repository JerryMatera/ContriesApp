package io.github.jerrymatera.explore.data.models

import com.google.gson.annotations.SerializedName


data class TranslationDetail(
    @SerializedName( "common")
    val common: String,
    @SerializedName( "official")
    val official: String
)