package data.model

import kotlinx.serialization.Serializable

@Serializable
data class Medicine(
    val id: Int,
    val title: String
)