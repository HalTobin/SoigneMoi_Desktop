package data.model

import kotlinx.serialization.Serializable

@Serializable
data class Specialty(
    val id: Int,
    val title: String
)