package com.app.evolvefit

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.os.LocaleListCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.app.evolvefit.common.ui.eventcontroller.EventController
import com.app.evolvefit.common.ui.extensions.ObserveAsEvents
import com.app.evolvefit.common.ui.languagecontroller.LanguageEvent
import com.app.evolvefit.common.ui.messagecontroller.MessageEvent
import com.app.evolvefit.common.ui.navigation.navigationcontroller.NavigationEvent
import com.app.evolvefit.common.ui.navigation.navigationcontroller.Navigator
import com.app.evolvefit.common.ui.stringhandler.UIText
import com.app.evolvefit.common.ui.theme.EvolveFitTheme
import org.koin.compose.koinInject
import org.koin.core.qualifier.named

val LocalPadding = compositionLocalOf<PaddingValues> { PaddingValues() }
// TODO EDIT LOADING TO FIT FOR EACH SCREEN AS UI
@Composable
fun EvolveFitApp(
    navigator: Navigator = koinInject(),
    navHostController: NavHostController = rememberNavController(),
) {
    EvolveFitTheme {
        ObserveMessageEvent()
        //ObserveLoadingEvent()
        ObserveLanguageEvent()
        ObserveAsEvents(navigator.navigationEvent) { event ->
            when (event) {
                is NavigationEvent.Navigate -> navHostController.navigate(
                    route = event.destination, builder = event.builder
                )

                NavigationEvent.NavigateUp -> navHostController.navigateUp()
            }
        }
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {

            },
            bottomBar = {

            }
        ) { innerPadding ->
            CompositionLocalProvider(LocalPadding provides innerPadding) {
                NavHost(
                    navController = navHostController,
                    startDestination = navigator.startGraph,
                ) {

                }
            }

        }
    }
}

@Composable
private fun ObserveMessageEvent() {
    val context = LocalContext.current

    @SuppressLint("LocalContextGetResourceValueCall")
    fun UIText.toMessageString(): String {
        return when (this) {
            is UIText.DynamicString -> this.value
            is UIText.StringResource -> context.getString(this.id)
        }
    }

    val messageEvent: EventController<MessageEvent> =
        koinInject(qualifier = named("MessageEvent"))
    ObserveAsEvents(messageEvent.event) { event ->
        when (event) {
            is MessageEvent.Toast -> {
                Toast.makeText(context, event.message.toMessageString(), Toast.LENGTH_LONG).show()
            }
        }
    }
}

/*@Composable
private fun ObserveLoadingEvent() {
    val loadingEvent: IEventController<ILoadingEvent> =
        koinInject(qualifier = named("LoadingEvent"))
    var isLoading by remember { mutableStateOf(false) }
    ObserveAsEvents(loadingEvent.event) { event ->
        when (event) {
            is ILoadingEvent.CircularProgressIndicator -> isLoading = event.isLoading
        }
    }
    if (isLoading) EvolveFitLoadingDialog()
}*/

@Composable
fun ObserveLanguageEvent() {
    val languageEvent: EventController<LanguageEvent> =
        koinInject(qualifier = named("LanguageEvent"))
    ObserveAsEvents(languageEvent.event) { event ->
        when (event) {
            is LanguageEvent.ChangeLanguage -> {
                val locale = LocaleListCompat.forLanguageTags(event.languageCode)
                AppCompatDelegate.setApplicationLocales(locale)
            }
        }
    }
}