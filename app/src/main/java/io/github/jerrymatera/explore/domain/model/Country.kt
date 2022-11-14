package io.github.jerrymatera.explore.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Country(
    val name: String,
    val capital: String,
    val flagImage: String,
)
