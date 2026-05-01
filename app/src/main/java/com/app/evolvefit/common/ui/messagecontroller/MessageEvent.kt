package com.app.evolvefit.common.ui.messagecontroller

import com.app.evolvefit.common.ui.stringhandler.UIText

interface MessageEvent {
    val message: UIText
    val messageType: MessageType

    data class Toast(
        override val message: UIText,
        override val messageType: MessageType = MessageType.DEFAULT
    ) : MessageEvent
}