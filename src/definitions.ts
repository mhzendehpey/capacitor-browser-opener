export interface OpenInDefaultParameterModel {
  /** The URL to be opened. It must contain either 'http' or 'https' as the protocol prefix. */
  url: string;
}
export interface BrowserOpenerPlugin {
  openInExternalBrowser(model: OpenInDefaultParameterModel): Promise<void>;
}
