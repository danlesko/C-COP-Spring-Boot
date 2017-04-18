import { UmbcSpr17TeamTrinityInnovationsPage } from './app.po';

describe('umbc-spr17-team-trinity-innovations App', function() {
  let page: UmbcSpr17TeamTrinityInnovationsPage;

  beforeEach(() => {
    page = new UmbcSpr17TeamTrinityInnovationsPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
