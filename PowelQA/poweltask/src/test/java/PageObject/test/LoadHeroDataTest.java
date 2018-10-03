package PageObject.test;

import PageObject.page.DashboardPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoadHeroDataTest extends BaseTestData {

    private DashboardPage dashboardPage;

    @Before
    public void prepareTest() {
        prepareDriver();
        dashboardPage = new DashboardPage(driver, baseUrl);
        dashboardPage.navigateToDashboard();
    }

    @After
    public void finishTest() {
        tearDown();
    }

    @Test
    public void testTopHero1Click() {
        checkTopHeroByIndex(1);
    }

    @Test
    public void testTopHero2Click() {
        checkTopHeroByIndex(2);
    }

    @Test
    public void testTopHero3Click() {
        checkTopHeroByIndex(3);
    }

    @Test
    public void testTopHero4Click() {
        checkTopHeroByIndex(4);
    }

    @Test
    public void testHeroByName() {
        String heroName = "Bombasto";
        dashboardPage.clickOnTopHero(heroName);
        String heroDetailsData = dashboardPage.getDetailsData();
        Assert.assertTrue(heroDetailsData.toUpperCase().contains(heroName.toUpperCase()));
    }

    private void checkTopHeroByIndex(int HeroIndex) {
        String heroName = dashboardPage.getTopHeroName(HeroIndex);
        dashboardPage.clickOnTopHero(HeroIndex);
        String heroDetailsData = dashboardPage.getDetailsData();
        Assert.assertTrue(heroDetailsData.toUpperCase().contains(heroName.toUpperCase()));
    }

}
