package features.caseanalytics.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class Weapon(
    val weaponName: String,
    val weaponImage: String
)
