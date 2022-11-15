package io.github.jerrymatera.explore.presentation.country_detail_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: DetailScreenViewModel
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.country?.let { country ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .safeContentPadding()
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            Icons.Filled.ArrowBack, contentDescription = null,
                            modifier = Modifier
                                .weight(1f)
                                .clickable {
                                    navController.popBackStack()
                                }
                        )
                        Text(
                            text = country.name,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.W700,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(9f)
                        )
                    }
                    AsyncImage(
                        model = country.flagImage,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 8.dp)

                    )
                    Text(
                        buildAnnotatedString {
                            append("Population: ")
                            withStyle(
                                style = SpanStyle(
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.W300,
                                    fontSize = 16.sp
                                )
                            ) {
                                append("${country.population}")
                            }
                        },
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                    )
                    Text(
                        buildAnnotatedString {
                            append("Region: ")
                            withStyle(
                                style = SpanStyle(
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.W300,
                                    fontSize = 16.sp
                                )
                            ) {
                                append(country.region)
                            }
                        },
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                    )
                    Text(
                        buildAnnotatedString {
                            append("Capital: ")
                            withStyle(
                                style = SpanStyle(
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.W300,
                                    fontSize = 16.sp
                                )
                            ) {
                                append(country.capital)
                            }
                        },
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                    )
                    Text(
                        buildAnnotatedString {
                            append("Language: ")
                            withStyle(
                                style = SpanStyle(
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.W300,
                                    fontSize = 16.sp
                                )
                            ) {
                                append(country.languages)
                            }
                        },
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                    )
                    Spacer(modifier = Modifier.height(100.dp))

                    Text(
                        buildAnnotatedString {
                            append("Location: ")
                            withStyle(
                                style = SpanStyle(
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.W300,
                                    fontSize = 16.sp
                                )
                            ) {
                                append(country.geographicalLocation)
                            }
                        },
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                    )
                    Text(
                        buildAnnotatedString {
                            append("Area: ")
                            withStyle(
                                style = SpanStyle(
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.W300,
                                    fontSize = 16.sp
                                )
                            ) {
                                append(country.area)
                            }
                        },
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                    )
                    Text(
                        buildAnnotatedString {
                            append("Landlocked: ")
                            withStyle(
                                style = SpanStyle(
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.W300,
                                    fontSize = 16.sp
                                )
                            ) {
                                append("${country.isLandLocked}")
                            }
                        },
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                    )
                    Text(
                        buildAnnotatedString {
                            append("Currency: ")
                            withStyle(
                                style = SpanStyle(
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.W300,
                                    fontSize = 16.sp
                                )
                            ) {
                                append("${country.currency}")
                            }
                        },
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                    )

                    Spacer(modifier = Modifier.height(100.dp))

                    Text(
                        buildAnnotatedString {
                            append("TimeZone: ")
                            withStyle(
                                style = SpanStyle(
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.W300,
                                    fontSize = 16.sp
                                )
                            ) {
                                append(country.timeZone)
                            }
                        },
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                    )
                    Text(
                        buildAnnotatedString {
                            append("DialingCode: ")
                            withStyle(
                                style = SpanStyle(
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.W300,
                                    fontSize = 16.sp
                                )
                            ) {
                                append(country.diallingCode)
                            }
                        },
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                    )
                    Text(
                        buildAnnotatedString {
                            append("Driving Side: ")
                            withStyle(
                                style = SpanStyle(
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.W300,
                                    fontSize = 16.sp
                                )
                            ) {
                                append(country.drivingSide)
                            }
                        },
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                    )
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}