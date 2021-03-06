/*
 * Copyright (C) 2020 Tu Yafeng
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.tuyafeng.watt.common

import android.os.Build

object Commands {
    fun removeAllRules(): String = "rm -f /data/system/ifw/*"

    fun setCaptivePortalServer(): String? {
        val server = "connect.rom.miui.com"
        return when {
            Build.VERSION.SDK_INT >= 25 -> "settings put global captive_portal_http_url http://$server/generate_204 ; " +
                    "settings put global captive_portal_https_url https://$server/generate_204"
            Build.VERSION.SDK_INT >= 21 -> "settings put global captive_portal_server $server"
            else -> null
        }
    }

    fun disableApp(pkg: String): String = "pm disable $pkg"

    fun enableApp(pkg: String): String = "pm enable $pkg"

    fun disableComponent(pkg: String, name: String): String = "pm disable $pkg/$name"

    fun enableComponent(pkg: String, name: String): String = "pm enable $pkg/$name"

    fun restoreComponent(pkg: String, name: String): String = "pm default-state $pkg/$name"
}

