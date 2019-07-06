import { browser, by, element } from 'protractor';

export class AppPage {
  static navigateTo() {
    browser.waitForAngularEnabled(false);
    return browser.get('/');
  }

  static getParagraph() {
    return element(by.css('app-dashboard p'));
  }
}
