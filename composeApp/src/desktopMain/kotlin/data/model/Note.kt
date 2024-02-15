package data.model

import data.api.DateSerializer
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Note(
    val id: Int,
    val appointmentId: Int,
    val doctorId: Int,
    val userId: Int,
    val title: String,
    val content: String,
    @Serializable(with = DateSerializer::class)
    val date: Date
)