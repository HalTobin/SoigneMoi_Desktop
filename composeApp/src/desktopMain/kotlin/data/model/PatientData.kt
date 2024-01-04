package data.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class PatientData(
    val id: Int,
    val name: String,
    val surname: String,
    val mail: String,
    val appointment: Appointment,
    val doctor: Doctor,
    val specialty: Specialty,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val notes: List<Note>,
    val prescriptions: List<Prescription>
)