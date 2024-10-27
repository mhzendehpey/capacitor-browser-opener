# capacitor-browser-opener

A basic alternarive to capacitor's in-app browser without increasing minSdk

## Install

```bash
npm install capacitor-browser-opener
npx cap sync
```

## API

<docgen-index>

* [`openInExternalBrowser(...)`](#openinexternalbrowser)
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


### Interfaces


#### OpenInDefaultParameterModel

| Prop      | Type                | Description                                                                            |
| --------- | ------------------- | -------------------------------------------------------------------------------------- |
| **`url`** | <code>string</code> | The URL to be opened. It must contain either 'http' or 'https' as the protocol prefix. |

</docgen-api>
