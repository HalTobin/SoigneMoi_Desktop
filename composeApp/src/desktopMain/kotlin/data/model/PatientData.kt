package data.model

import java.util.*

data class PatientData(
    val id: Int,
    val name: String,
    val surname: String,
    val mail: String,
    val appointment: Appointment,
    val doctor: Doctor,
    val specialty: Specialty,
    val startDate: Date,
    val endDate: Date,
    val notes: List<Note>,
    val prescriptions: List<Prescription>
)