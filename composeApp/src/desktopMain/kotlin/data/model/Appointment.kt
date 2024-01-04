package data.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Appointment(
    val id: Int,
    val visitorId: Int,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val reason: String,
    val specialty: String,
    val doctor: String
)
