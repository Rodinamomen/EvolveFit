package com.app.evolvefit

import android.app.Application
import com.app.evolvefit.common.di.appModule
import com.app.evolvefit.common.di.localDataSourceModule
import com.app.evolvefit.common.di.remoteDataSourceModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            androidLogger()
            modules(
                appModule,
                remoteDataSourceModule,
                localDataSourceModule,
            )
        }
    }
}