import { registerPlugin } from '@capacitor/core';

import type { BrowserOpenerPlugin } from './definitions';

const BrowserOpener = registerPlugin<BrowserOpenerPlugin>('BrowserOpener', {
  web: () => import('./web').then((m) => new m.BrowserOpenerWeb()),
});

export * from './definitions';
export { BrowserOpener };
