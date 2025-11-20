package com.mxz.capacitor.plugin.browser.opener

import android.content.Intent
import androidx.core.net.toUri
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
            call.reject("The value of the 'url' input parameter is missing or empty.")
            return
        }

        if (!isSchemeValid(url)) {
            call.reject("The URL provided must begin with either http:// or https://.")
            return
        }

        try {
            val uri = url.toUri()
            val intent = Intent(Intent.ACTION_VIEW, uri)

            // Add category BROWSABLE to match standard browser filters
            intent.addCategory(Intent.CATEGORY_BROWSABLE)

            // 2. Find all apps that can handle this URL (Browsers + Your App)
            val packageManager = activity.packageManager
            val resolvedActivities = packageManager.queryIntentActivities(intent, 0)

            // 3. Filter out YOUR own app package
            // We look for an activity where the packageName is NOT this app's packageName
            val externalBrowser = resolvedActivities.firstOrNull { resolveInfo ->
                resolveInfo.activityInfo.packageName != activity.packageName
            }

            if (externalBrowser != null) {
                // 4. Force the intent to use the found external browser
                intent.setPackage(externalBrowser.activityInfo.packageName)
            } else {
                // Edge case: No other browser found?
                // The user might strictly only have your app installed (rare),
                // or Android 11+ visibility rules are hiding the browser (see below).
                // We will let it fall through to standard execution, though it might loop.
            }

            // 5. Flag for new task to ensure it opens in a separate window stack
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            activity.startActivity(intent)
            call.resolve()
        } catch (e: Exception) {
            call.reject("An error occurred while trying to open the external browser: ${e.message}")
        }
    }

    @PluginMethod
    fun reload(call: PluginCall) {
        try {
            val webView = this.bridge.webView;
            webView.post {
                webView.reload()
                call.resolve()
            }
        } catch (e: Exception) {
            call.reject("An error occurred while trying to reload webView: ${e.message}")
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
