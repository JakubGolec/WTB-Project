import { AppPage } from './app.po';

describe('app-dashboard component', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should exist', () => {
    AppPage.navigateTo();
    expect(AppPage.getParagraph().isPresent()).toBe(true);
  });
});
