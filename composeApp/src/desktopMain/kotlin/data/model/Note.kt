package data.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val id: Int,
    val appointmentId: Int,
    val doctorId: Int,
    val userId: Int,
    val title: String,
    val content: String,
    val date: LocalDateTime
)