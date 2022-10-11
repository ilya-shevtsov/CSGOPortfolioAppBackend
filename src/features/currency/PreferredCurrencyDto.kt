package features.currency

import kotlinx.serialization.Serializable

@Serializable
data class PreferredCurrencyDto(
    val preferredCurrency: Int
)


