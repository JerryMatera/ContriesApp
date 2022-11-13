package io.github.jerrymatera.explore.data.models

import com.google.gson.annotations.SerializedName

data class Idd(
    @SerializedName( "root")
    val root: String,
    @SerializedName( "suffixes")
    val suffixes: List<String>
)