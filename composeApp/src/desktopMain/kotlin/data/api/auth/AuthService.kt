package data.api.auth

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(val mail: String, val password: String)

@Serializable
data class TokenResponse(val accessToken: String, val tokenType: String, val role: String, val validity: Long)

@OptIn(InternalAPI::class)
class AuthService(private val baseUrl: String) {
    private val client = HttpClient {
        install(Logging)
        install(ContentNegotiation) {
            json()
        }
    }

    fun HttpRequestBuilder.endPoint(path: String) {
        url {
            takeFrom(baseUrl)
            path(path)
            contentType(ContentType.Application.Json)
        }
    }

    suspend fun login(credentials: LoginRequest): TokenResponse? {
        val response = client.post {
            endPoint("auth/login")
            setBody(credentials)
        }
        return if (response.status == HttpStatusCode.OK) response.body()
        else null
    }
}