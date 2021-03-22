package com.ilya.shevtsov.casewatcher


import kotlinx.serialization.Serializable


@Serializable
data class HelloWorldResponse(
    val hello: String,
    val world: String
)