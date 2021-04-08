package com.ilya.shevtsov.casewatcher.data.api.database


import kotlinx.serialization.Serializable


@Serializable
data class CaseDbo(
        val id: Int,
        val name: String,
        val releaseDate: String,
        val dropStatus: String,
        val lowestPrice: Double,
        val volume: Int,
        val medianPrice: Double,
        val imageUrl: String,
        val description: String
)