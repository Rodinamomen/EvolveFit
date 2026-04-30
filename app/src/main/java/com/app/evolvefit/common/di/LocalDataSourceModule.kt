package com.app.evolvefit.common.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.app.evolvefit.common.data.repo.local.KeyValueDataSourceProviderImp
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val localDataSourceModule = module {
    single<DataStore<Preferences>> {
        PreferenceDataStoreFactory.create {
            get<Context>().preferencesDataStoreFile("app_datastore")
        }
    }
    singleOf(::KeyValueDataSourceProviderImp) bind KeyValueDataSourceProviderImp::class
}