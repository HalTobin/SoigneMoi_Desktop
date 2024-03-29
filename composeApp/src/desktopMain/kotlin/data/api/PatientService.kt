package data.api

import data.model.Patient
import data.model.PatientData
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.*
import org.jetbrains.compose.resources.load
import util.ConstUrl

@OptIn(InternalAPI::class)
class PatientService(token: String) {

    private val client = HttpClient {
        install(Logging)
        install(ContentNegotiation) {
            json()
        }
        install(Auth) {
            bearer {
                loadTokens { BearerTokens(accessToken = token, refreshToken = "") }
            }
        }
    }

    fun HttpRequestBuilder.endPoint(path: String) {
        url {
            takeFrom(ConstUrl.BASE_URL)
            path(path)
            contentType(ContentType.Application.Json)
        }
    }

    suspend fun getPatients(): List<Patient> {
        val response = client.get {
            endPoint("api/secretary/today_patients")
        }
        return if (response.status == HttpStatusCode.OK) response.body()
        else emptyList()
    }

    suspend fun getPatientDetails(patientId: Int): PatientData? {
        val response = client.get {
            endPoint("api/secretary/patient_details")
            parameter("patientId", patientId)
        }
        return if (response.status == HttpStatusCode.OK) response.body()
        else null
    }

}