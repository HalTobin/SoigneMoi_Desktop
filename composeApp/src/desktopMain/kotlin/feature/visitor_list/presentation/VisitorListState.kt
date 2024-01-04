package feature.visitor_list.presentation

import data.model.Patient
import data.model.PatientData

data class VisitorListState(
    val patients: List<Patient> = emptyList(),
    val patientData: PatientData? = null
)