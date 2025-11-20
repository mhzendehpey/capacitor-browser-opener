# capacitor-browser-opener

A basic alternative to capacitor's in-app browser without increasing minSdk

## Install

```bash
npm install capacitor-browser-opener
npx cap sync
```

## Android 11+ (API 30) Configuration Guide

If your application targets **Android 11 (API Level 30)** or higher, you must explicitly declare that your app needs to query for external web browsers.

Without this configuration, Android's **Package Visibility** restrictions will prevent the plugin from detecting installed browsers (like Chrome, Firefox, or Samsung Internet), causing the `openInExternalBrowser` function to fail or fall back to opening your own app (creating an app loop).

### 1. Update Your Manifest

Open your app's `AndroidManifest.xml` file. This is typically located at:
`android/app/src/main/AndroidManifest.xml`

### 2. Add the `<queries>` Element

Add the `<queries>` block inside the `<manifest>` tag, but **outside** the `<application>` tag.

Copy and paste the following code:

```xml

<manifest xmlns:android="[http://schemas.android.com/apk/res/android](http://schemas.android.com/apk/res/android)"
          package="your.package.name">

    <queries>
        <intent>
            <action android:name="android.intent.action.VIEW"/>
            <data android:scheme="https"/>
        </intent>
        <intent>
            <action android:name="android.intent.action.VIEW"/>
            <data android:scheme="http"/>
        </intent>
    </queries>

    <application
            android:allowBackup="true"
            android:label="@string/app_name">
    </application>

</manifest>
```

## API

<docgen-index>

* [`openInExternalBrowser(...)`](#openinexternalbrowser)
* [`reload()`](#reload)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### openInExternalBrowser(...)

```typescript
openInExternalBrowser(model: OpenInDefaultParameterModel) => Promise<void>
```

| Param       | Type                                                                                |
| ----------- | ----------------------------------------------------------------------------------- |
| **`model`** | <code><a href="#openindefaultparametermodel">OpenInDefaultParameterModel</a></code> |

--------------------


### reload()

```typescript
reload() => void
```

--------------------


### Interfaces


#### OpenInDefaultParameterModel

| Prop      | Type                | Description                                                                            |
| --------- | ------------------- | -------------------------------------------------------------------------------------- |
| **`url`** | <code>string</code> | The URL to be opened. It must contain either 'http' or 'https' as the protocol prefix. |

</docgen-api>
