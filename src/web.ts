import { WebPlugin } from '@capacitor/core';

import type { BrowserOpenerPlugin } from './definitions';

export class BrowserOpenerWeb extends WebPlugin implements BrowserOpenerPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
