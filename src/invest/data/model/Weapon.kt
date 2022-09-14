package invest.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Weapon(
    val weaponName: String,
    val weaponImage: String
)
