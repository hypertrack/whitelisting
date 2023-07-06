package com.hypetrack.whitelisting

internal sealed class WhitelistingIntentData(val packageValue: String, val componentValue: String)
internal object SamsungWhitelistingData: WhitelistingIntentData(
    packageValue = SAMSUNG_PACKAGE,
    componentValue = SAMSUNG_COMPONENT
)
internal object XiaomiWhitelistingData: WhitelistingIntentData(
    packageValue = XIAOMI_PACKAGE,
    componentValue = XIAOMI_COMPONENT
)
internal object OnePlusWhitelistingData: WhitelistingIntentData(
    packageValue = ONEPLUS_PACKAGE,
    componentValue = ONEPLUS_COMPONENT
)
internal object HuaweiWhitelistingData: WhitelistingIntentData(
    packageValue = HUAWEI_PACKAGE,
    componentValue = HUAWEI_COMPONENT
)


private const val SAMSUNG_PACKAGE = "com.samsung.android.lool"
private const val SAMSUNG_COMPONENT =
    "com.samsung.android.sm.battery.ui.setting.BatterySettingsActivity"
private const val XIAOMI_PACKAGE = "com.miui.securitycenter"
private const val XIAOMI_COMPONENT = "com.miui.permcenter.autostart.AutoStartManagementActivity"
private const val ONEPLUS_PACKAGE = "com.oneplus.security"
private const val ONEPLUS_COMPONENT =
    "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity"
private const val HUAWEI_PACKAGE = "com.huawei.systemmanager"
private const val HUAWEI_COMPONENT = "com.huawei.systemmanager.optimize.process.ProtectActivity"
