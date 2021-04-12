package data.model.caseDbo

import kotlinx.serialization.Serializable

@Serializable
data class CaseDbo(
    val id: Int = 0,
    val caseAccess: String,
    val name: String,
    val releaseDate: String,
    val dropStatus: String,
    val lowestPrice: Double,
    val volume: Int,
    val medianPrice: Double,
    val imageUrl: String,
    val description: String
)