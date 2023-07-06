package com.hypetrack.whitelisting

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import java.util.*

private const val BRAND_NAME_SAMSUNG = "samsung"
private const val BRAND_NAME_HUAWEI = "huawei"
private const val BRAND_NAME_HUAWEI_HONOR = "honor"
private const val BRAND_NAME_XIAOMI = "xiaomi"
private const val BRAND_NAME_XIAOMI_REALME = "realme"
private const val BRAND_NAME_XIAOMI_POCO = "poco"
private const val BRAND_NAME_ONEPLUS = "oneplus"
private const val BRAND_NAME_VIVO = "vivo"
private const val BRAND_NAME_ASUS = "asus"
private const val BRAND_NAME_WIKO = "wiko"
private const val BRAND_NAME_LENOVO = "lenovo"
private const val BRAND_NAME_OPPO = "oppo"
private const val BRAND_NAME_REALME = "realme"
private const val BRAND_NAME_BLACKVIEW = "blackview"
private const val BRAND_NAME_GOOGLE = "google"
private const val BRAND_NAME_NOKIA = "nokia"
private const val BRAND_NAME_SONY = "sony"
private const val BRAND_NAME_OTHER = "other"

enum class Brand(val names: Set<String>, val suffix: String?) {
    Samsung(setOf(BRAND_NAME_SAMSUNG), BRAND_NAME_SAMSUNG),
    Huawei(setOf(BRAND_NAME_HUAWEI, BRAND_NAME_HUAWEI_HONOR), BRAND_NAME_HUAWEI),
    Xiaomi(
        setOf(
            BRAND_NAME_XIAOMI,
            BRAND_NAME_XIAOMI_REALME,
            BRAND_NAME_XIAOMI_POCO
        ),
        BRAND_NAME_XIAOMI
    ),
    OnePlus(setOf(BRAND_NAME_ONEPLUS), BRAND_NAME_ONEPLUS),
    Vivo(setOf(BRAND_NAME_VIVO), BRAND_NAME_VIVO),
    Asus(setOf(BRAND_NAME_ASUS), BRAND_NAME_ASUS),
    Wiko(setOf(BRAND_NAME_WIKO), BRAND_NAME_WIKO),
    Lenovo(setOf(BRAND_NAME_LENOVO), BRAND_NAME_LENOVO),
    Oppo(setOf(BRAND_NAME_OPPO), BRAND_NAME_OPPO),
    Realme(setOf(BRAND_NAME_REALME), BRAND_NAME_REALME),
    Blackview(setOf(BRAND_NAME_BLACKVIEW), BRAND_NAME_BLACKVIEW),
    Google(setOf(BRAND_NAME_GOOGLE), BRAND_NAME_GOOGLE),
    Nokia(setOf(BRAND_NAME_NOKIA), BRAND_NAME_NOKIA),
    Sony(setOf(BRAND_NAME_SONY), BRAND_NAME_SONY),
    Other(setOf(), null);

    //todo test
    companion object {
        private val brandName: String = Build.BRAND
        private val manufacturerName: String = Build.MANUFACTURER

        val ofCurrentDevice: Brand by lazy {
            for (b in values()) {
                for (n in b.names) {
                    if (manufacturerName.lowercase(Locale.ROOT).contains(n)
                        || brandName.lowercase(Locale.ROOT).contains(n)
                    ) {
                        return@lazy b
                    }
                }
            }
            return@lazy Other
        }
    }
}
