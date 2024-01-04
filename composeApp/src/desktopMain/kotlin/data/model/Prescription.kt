package data.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Prescription(
    val id: Int,
    val appointmentId: Int,
    val start: LocalDateTime,
    val end: LocalDateTime,
    val entries: List<PrescriptionEntry>,
) {

    fun getMedicinesAsString(): String {
        var result = ""
        entries.forEachIndexed { index, entry ->
            result += entry.medicine.title
            if (index < entries.lastIndex) result += ", "
        }
        return result
    }

}
