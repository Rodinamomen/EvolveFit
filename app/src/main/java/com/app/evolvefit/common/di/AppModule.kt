package com.app.evolvefit.common.di

import com.app.evolvefit.common.ui.eventcontroller.EventController
import com.app.evolvefit.common.ui.eventcontroller.EventControllerImp
import com.app.evolvefit.common.ui.exceptionhandler.ExceptionHandler
import com.app.evolvefit.common.ui.languagecontroller.LanguageController
import com.app.evolvefit.common.ui.languagecontroller.LanguageEvent
import com.app.evolvefit.common.ui.loadingcontroller.LoadingController
import com.app.evolvefit.common.ui.loadingcontroller.LoadingEvent
import com.app.evolvefit.common.ui.messagecontroller.MessageController
import com.app.evolvefit.common.ui.messagecontroller.MessageEvent
import com.app.evolvefit.common.ui.navigation.navigationcontroller.NavigationController
import kotlinx.coroutines.CoroutineScope
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single<EventController<MessageEvent>>(qualifier = named("MessageEvent")) { EventControllerImp() }
    single<EventController<LoadingEvent>>(qualifier = named("LoadingEvent")) { EventControllerImp() }
    single<EventController<LanguageEvent>>(qualifier = named("LanguageEvent")) { EventControllerImp() }
    factory { (scope: CoroutineScope) -> LanguageController(scope) }
    factory { (scope: CoroutineScope) -> MessageController(scope) }
    factory { (scope: CoroutineScope) -> LoadingController(scope) }
    factory { (scope: CoroutineScope) -> NavigationController(scope) }
    factoryOf(::ExceptionHandler)
}