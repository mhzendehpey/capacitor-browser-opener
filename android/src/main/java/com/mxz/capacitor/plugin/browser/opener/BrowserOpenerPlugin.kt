package com.mxz.capacitor.plugin.browser.opener

import android.content.Intent
import android.net.Uri
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin


@CapacitorPlugin(name = "BrowserOpener")
class BrowserOpenerPlugin : Plugin() {

    @PluginMethod
    fun openInExternalBrowser(call: PluginCall) {
        val url = call.getString("url")
        if (url.isNullOrEmpty()) {
            call.reject("The value of the 'url' input parameter of the 'openInExternalBrowser' action is missing or is empty.")
            return
        }

        if (!isSchemeValid(url)) {
            call.reject("The URL provided must begin with either http:// or https://.")
            return
        }

        try {
            activity.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(url)
                )
            )
            call.resolve()
        } catch (e: Exception) {
            call.reject("An error occurred while trying to open the external browser: ${e.message}")
        }
    }

    /**
     * Determines if URL scheme is valid - it must start with either 'http://' or 'https://'
     * @param url string with URL to validate
     */
    private fun isSchemeValid(url: String): Boolean {
        return listOf("http://", "https://").any { url.startsWith(it, true) }
    }
}
