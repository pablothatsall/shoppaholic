import { ShoppaholicAngularPage } from './app.po';

describe('shoppaholic-angular App', function() {
  let page: ShoppaholicAngularPage;

  beforeEach(() => {
    page = new ShoppaholicAngularPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
