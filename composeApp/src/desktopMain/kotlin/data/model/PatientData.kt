package data.model

import data.api.DateSerializer
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class PatientData(
    val id: Int,
    val name: String,
    val surname: String,
    val mail: String,
    val appointment: Appointment,
    val doctor: Doctor,
    val specialty: Specialty,
    @Serializable(with = DateSerializer::class)
    val startDate: Date,
    @Serializable(with = DateSerializer::class)
    val endDate: Date,
    val notes: List<Note>,
    val prescriptions: List<Prescription>
)