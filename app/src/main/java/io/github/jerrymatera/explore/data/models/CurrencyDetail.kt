package io.github.jerrymatera.explore.data.models

import com.google.gson.annotations.SerializedName

class CurrencyDetail(
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?
)
