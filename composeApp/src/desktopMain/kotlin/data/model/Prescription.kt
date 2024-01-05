package data.model

import data.api.DateSerializer
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Prescription(
    val id: Int,
    val appointmentId: Int,
    @Serializable(with = DateSerializer::class)
    val start: Date,
    @Serializable(with = DateSerializer::class)
    val end: Date,
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
