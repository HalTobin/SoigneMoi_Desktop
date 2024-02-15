package data.model

import kotlinx.serialization.Serializable

@Serializable
data class Patient(
    val id: Int,
    val name: String,
    val surname: String,
    val reason: String,
    val entry: Boolean
)