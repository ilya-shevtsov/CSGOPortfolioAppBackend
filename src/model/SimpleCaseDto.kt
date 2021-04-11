package model

import kotlinx.serialization.Serializable

@Serializable
data class SimpleCaseDto(
    val name: String,
    val lowestPrice: Double,
    val volume: Int,
    val medianPrice: Double,
)