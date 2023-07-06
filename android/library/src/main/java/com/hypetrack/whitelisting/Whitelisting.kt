package com.hypetrack.whitelisting

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NO_HISTORY
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.net.Uri
import android.provider.Settings

object Whitelisting {

    fun showPrompt(context: Context) {
        // todo timeout
        context.startActivity(Intent(context, WhitelistingActivity::class.java).apply {
            addFlags(FLAG_ACTIVITY_SINGLE_TOP or FLAG_ACTIVITY_NO_HISTORY)
        })
    }

    // todo
    @SuppressLint("QueryPermissionsNeeded")
    private fun getWhitelistingIntentForDevice(brand: Brand, context: Context): Intent {
        val intentData = when (brand) {
            Brand.Samsung -> SamsungWhitelistingData
            Brand.Huawei -> HuaweiWhitelistingData
            Brand.Xiaomi -> XiaomiWhitelistingData
            Brand.OnePlus -> OnePlusWhitelistingData
            else -> null
        }
        return if(intentData != null) {
            try {
                val specificIntent = Intent().apply {
                    component = ComponentName(intentData.packageValue, intentData.componentValue)
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
                val list: List<ResolveInfo> = context.packageManager
                    .queryIntentActivities(specificIntent, PackageManager.MATCH_DEFAULT_ONLY)
                if (list.isNotEmpty()) {
                    specificIntent
                } else {
                    getAppSettingsIntent(context)
                }
            } catch (e: Exception) {
                getAppSettingsIntent(context)
            }
        } else {
            getAppSettingsIntent(context)
        }
    }

    private fun getAppSettingsIntent(context: Context): Intent {
        return Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NO_ANIMATION
            data = Uri.fromParts("package", context.packageName, null)
        }
    }

}
