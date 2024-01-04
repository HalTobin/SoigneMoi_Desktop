package data.model

import data.Strings
import kotlinx.serialization.Serializable

@Serializable
data class PrescriptionEntry(
    val prescriptionId: Int,
    val dosage: Int,
    val frequency: Int,
    val note: String,
    val medicine: Medicine
)


enum class Frequency(val id: Int, val title: String) {
    DAILY(0, Strings.DAILY),
    WEEKLY(1, Strings.WEEKLY),
    MONTHLY(2, Strings.MONTHLY);

    companion object {

        val all = listOf(DAILY, WEEKLY, MONTHLY)

        fun getFromId(id: Int): Frequency {
            return when (id) {
                0 -> DAILY
                1 -> WEEKLY
                2 -> MONTHLY
                else -> DAILY
            }
        }

    }
}
