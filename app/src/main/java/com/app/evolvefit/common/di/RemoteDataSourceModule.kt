package com.app.evolvefit.common.di

import com.app.evolvefit.common.data.repo.remote.RemoteDataSourceProviderImp
import com.app.evolvefit.common.data.repo.remote.provideHttpClient
import com.app.evolvefit.common.domain.repo.remote.RemoteDataSourceProvider
import kotlinx.serialization.json.Json
import org.koin.dsl.bind
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<Json> {
        Json {
            ignoreUnknownKeys = true
            prettyPrint = true
            isLenient = true
            encodeDefaults = true
        }
    }
    single<RemoteDataSourceProviderImp> {
        RemoteDataSourceProviderImp(
            provideHttpClient(get()),
            get()
        )
    } bind RemoteDataSourceProvider::class
}