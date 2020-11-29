package com.leeby.nobodyknowing

import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class NobodyKnowingNotificationListenerService : NotificationListenerService() {
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        sbn?.notification?.extras?.let {
            Log.i("NotificationListener", "[NobodyKnowing] onNotificationPosted() - $sbn")
            Log.i("NotificationListener", "[NobodyKnowing] PackageName: ${sbn.packageName}")
            Log.i("NotificationListener", "[NobodyKnowing] PostTime: ${sbn.postTime}")

            val title = it.getString(Notification.EXTRA_TITLE)
            val text = it.getCharSequence(Notification.EXTRA_TEXT)
            val subText = it.getCharSequence(Notification.EXTRA_SUB_TEXT)

            Log.i("NotificationListener", "[NobodyKnowing]: Title: $title")
            Log.i("NotificationListener", "[NobodyKnowing]: Text: $text")
            Log.i("NotificationListener", "[NobodyKnowing]: SubText: $subText")
        } ?: Log.e("NotificationListener", "[NobodyKnowing] extra is null")
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        Log.i("NotificationListener", "[NobodyKnowing] onNotificationRemoved() - ${sbn.toString()}")
    }
}