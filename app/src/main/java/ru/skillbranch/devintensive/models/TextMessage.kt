package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

class TextMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncaming: Boolean = false,
    date: Date = Date(),
    var text: String?
) : BaseMessage(id, from, chat, isIncaming, date) {

    override fun formatMessage(): String = "${from?.firstName}" +
            " ${if (isIncoming) "получил" else "отправил"} сообщение \"$text\" ${Date().humanizeDiff(date)}"


}