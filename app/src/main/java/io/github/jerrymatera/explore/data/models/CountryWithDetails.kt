package io.github.jerrymatera.explore.data.models

data class CountryWithDetails(
    val altSpellings: List<String>,
    val area: Double,
    val capital: List<String>,
    val capitalInfo: CapitalInfo,
    val car: Car,
    val coatOfArms: CoatOfArms,
    val continents: List<String>,
    val currencies: Currencies,
    val fifa: String,
    val flag: String,
    val flags: Flags,
    val idd: Idd,
    val languages: Languages,
    val latlng: List<Double>,
    val maps: Maps,
    val name: Name,
    val population: Int,
    val postalCode: PostalCode,
    val region: String,
    val startOfWeek: String,
    val subregion: String,
    val timezones: List<String>,
    val tld: List<String>
)