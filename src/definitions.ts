export interface BrowserOpenerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
