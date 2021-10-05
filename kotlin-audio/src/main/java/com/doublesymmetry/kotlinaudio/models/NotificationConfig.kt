package com.doublesymmetry.kotlinaudio.models

import android.app.PendingIntent
import androidx.annotation.DrawableRes
import com.google.android.exoplayer2.ui.PlayerNotificationManager.*

/**
 * Used to configure the player notification.
 * @param buttons The buttons that would appear on the notification.
 * @param pendingIntent The [PendingIntent] that would be called when tapping on the notification itself.
 */
data class NotificationConfig(val buttons: List<NotificationButton>, val pendingIntent: PendingIntent? = null)

sealed class NotificationButton(@DrawableRes val icon: Int?) {
    class PLAY(@DrawableRes icon: Int? = null): NotificationButton(icon)
    class PAUSE(@DrawableRes icon: Int? = null): NotificationButton(icon)
    class STOP(@DrawableRes icon: Int? = null): NotificationButton(icon)
    class FORWARD(@DrawableRes icon: Int? = null, val isCompact: Boolean = false): NotificationButton(icon)
    class BACKWARD(@DrawableRes icon: Int? = null, val isCompact: Boolean = false): NotificationButton(icon)
    class NEXT(@DrawableRes icon: Int? = null, val isCompact: Boolean = false): NotificationButton(icon)
    class PREVIOUS(@DrawableRes icon: Int? = null, val isCompact: Boolean = false): NotificationButton(icon)

    enum class Action {
        PLAY, PAUSE, STOP, FORWARD, REWIND, NEXT, PREVIOUS
    }

    companion object {
        internal fun valueOf(value: String): Action {
            return when(value) {
                ACTION_PLAY -> Action.PLAY
                ACTION_PAUSE -> Action.PAUSE
                ACTION_STOP -> Action.STOP
                ACTION_FAST_FORWARD -> Action.FORWARD
                ACTION_REWIND -> Action.REWIND
                ACTION_NEXT -> Action.NEXT
                ACTION_PREVIOUS -> Action.PREVIOUS
                else -> error("No such action exists")
            }
        }
    }
}