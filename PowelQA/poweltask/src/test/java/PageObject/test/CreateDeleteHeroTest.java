package PageObject.test;

import PageObject.page.HeroesPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateDeleteHeroTest extends BaseTestData {

        private HeroesPage heroesPage;

    @Before
    public void prepareTest() {
        prepareDriver();
        heroesPage = new HeroesPage(driver, baseUrl);
        heroesPage.navigateToHeroes();
    }

    @Test
    public void addDeleteHero() {
        heroesPage.addHero("Wiedzmin");
        int heroIndex = heroesPage.getHeroId("Wiedzmin");
        Assert.assertNotEquals(0, heroIndex);
        heroesPage.deleteHero("Wiedzmin");
        heroIndex = heroesPage.getHeroId("Wiedzmin");
        Assert.assertEquals(0, heroIndex);
    }

    @After
    public void finishTest() {
        tearDown();
    }
}
