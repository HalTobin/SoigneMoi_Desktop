package data.model

import data.model.Specialty
import kotlinx.serialization.Serializable

@Serializable
data class Doctor(
    val id: Int,
    val name: String,
    val surname: String,
    val registrationNumber: String,
    val specialty: Specialty
)
