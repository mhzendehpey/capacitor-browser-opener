/* eslint-disable @typescript-eslint/ban-ts-comment */
/* eslint-disable @typescript-eslint/no-unused-vars */
import { WebPlugin } from '@capacitor/core';

import type { BrowserOpenerPlugin, OpenInDefaultParameterModel } from './definitions';

export class BrowserOpenerWeb extends WebPlugin implements BrowserOpenerPlugin {
  //@ts-ignore
  openInExternalBrowser(model: OpenInDefaultParameterModel): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  reload(): void {
    window?.location?.reload();
  }
}
