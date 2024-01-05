package data.model

import data.api.DateSerializer
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Appointment(
    val id: Int,
    val visitorId: Int,
    @Serializable(with = DateSerializer::class)
    val startDate: Date,
    @Serializable(with = DateSerializer::class)
    val endDate: Date,
    val reason: String,
    val specialty: String,
    val doctor: String
)
