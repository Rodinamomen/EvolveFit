package com.app.evolvefit.common.domain.repo.remote

import com.app.evolvefit.common.data.model.NetworkMethods
import com.app.evolvefit.common.domain.model.file.File
import kotlinx.serialization.KSerializer

interface RemoteDataSourceProvider{
    suspend  fun <ResponseBody, RequestBody> request(
        method: NetworkMethods,
        path: String,
        params: Map<String, Any>?= null,
        headers: Map<String, Any>?= null,
        requestBody: RequestBody?= null,
        files: List<Pair<String, File>> = emptyList(),
        serializer: KSerializer<ResponseBody>,
    ): ResponseBody
}