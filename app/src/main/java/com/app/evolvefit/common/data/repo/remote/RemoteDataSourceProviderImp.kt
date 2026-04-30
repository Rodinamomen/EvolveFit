package com.app.evolvefit.common.data.repo.remote

import com.app.evolvefit.common.data.model.NetworkMethods
import com.app.evolvefit.common.domain.model.file.File
import com.app.evolvefit.common.domain.repo.remote.RemoteDataSourceProvider
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.delete
import io.ktor.client.request.forms.FormPart
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.utils.io.InternalAPI
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

class RemoteDataSourceProviderImp(private val client: HttpClient, private val json: Json) :
    RemoteDataSourceProvider {
    @OptIn(InternalAPI::class)
    override suspend fun <ResponseBody, RequestBody> request(
        method: NetworkMethods,
        path: String,
        params: Map<String, Any>?,
        headers: Map<String, Any>?,
        requestBody: RequestBody?,
        files: List<Pair<String, File>>,
        serializer: KSerializer<ResponseBody>,
    ): ResponseBody {
        val response: HttpResponse = when (method) {
            NetworkMethods.POST -> {
                if (isBaseUrl(path)) {
                    client.post() {
                        configureUrl(path)
                        configureParams(params)
                        configureHeaders(headers)
                        requestBody?.let { setBody(it) }
                    }
                } else {
                    client.post(path) {
                        configureParams(params)
                        configureHeaders(headers)
                        requestBody?.let { setBody(it) }
                    }
                }
            }

            NetworkMethods.GET -> {
                if (isBaseUrl(path)) {
                    client.get {
                        configureUrl(path)
                        configureParams(params)
                        configureHeaders(headers)
                    }
                } else {
                    client.get(path) {
                        configureParams(params)
                        configureHeaders(headers)
                    }
                }
            }

            NetworkMethods.PUT -> {
                if (isBaseUrl(path)) {
                    client.put {
                        configureUrl(path)
                        configureParams(params)
                        configureHeaders(headers)
                        requestBody?.let { setBody(it) }
                    }
                } else {
                    client.put(path) {
                        configureParams(params)
                        configureHeaders(headers)
                        requestBody?.let { setBody(it) }
                    }
                }
            }

            NetworkMethods.DELETE -> {
                if (isBaseUrl(path)) {
                    client.delete {
                        configureUrl(path)
                        configureParams(params)
                        configureHeaders(headers)
                    }
                } else {
                    client.delete(path) {
                        configureParams(params)
                        configureHeaders(headers)
                    }
                }
            }

            NetworkMethods.POST_WITH_FILES -> {
                if (isBaseUrl(path)) {
                    client.post {
                        configureUrl(path)
                        configureParams(params)
                        configureHeaders(headers)
                        body = createMultiPartFormData(files, requestBody)
                    }
                } else {
                    client.post(path) {
                        configureParams(params)
                        configureHeaders(headers)
                        body = createMultiPartFormData(files, requestBody)
                    }
                }
            }
        }
        return handleResponse(response, serializer)
    }

    private fun isBaseUrl(path: String): Boolean {
        return path.startsWith("https")
    }

    private fun HttpRequestBuilder.configureUrl(path: String) = url(path)
    private fun HttpRequestBuilder.configureParams(params: Map<String, Any>?) {
        params?.forEach { (key, value) ->
            url.parameters.append(key, value.toString())
        }
    }

    private fun HttpRequestBuilder.configureHeaders(headers: Map<String, Any>?) {
        headers?.forEach { (key, value) ->
            header(key, value)
        }
    }

    private fun createMultiPartFormData(
        files: List<Pair<String, File>>,
        requestBody: Any?,
    ): MultiPartFormDataContent {
        return MultiPartFormDataContent(
            formData {
                files.forEach { (key, file) ->
                    append(
                        FormPart(
                            key = key,
                            value = file.value,
                            headers = Headers.build {
                                append(
                                    HttpHeaders.ContentDisposition,
                                    "form-data; name=\"$key\"; filename=\"${file.name}\""
                                )
                            }
                        ))
                }
                (requestBody as? Map<*, *>)?.forEach { (key, value) ->
                    append(key = key.toString(), value = value.toString())
                }
            }
        )
    }

    private suspend fun <ResponseBody> handleResponse(
        response: HttpResponse,
        serializer: KSerializer<ResponseBody>,
    ): ResponseBody {
        val responseBodyText = response.bodyAsText()
        return json.decodeFromString(serializer, responseBodyText)
    }
}