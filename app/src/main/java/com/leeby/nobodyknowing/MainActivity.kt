package com.leeby.nobodyknowing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isNotificationPermissionAllowed()) {
            // notification 퍼미션 권한 요구 액티비티 시작
            val intent = Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS")
            startActivity(intent)
        }
    }

    private fun isNotificationPermissionAllowed(): Boolean {
        val notificationListenerSet = NotificationManagerCompat.getEnabledListenerPackages(this)
        val myPackageName = packageName

        return notificationListenerSet.contains(myPackageName)
    }
}
