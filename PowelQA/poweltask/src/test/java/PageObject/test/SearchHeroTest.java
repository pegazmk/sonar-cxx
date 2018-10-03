package PageObject.test;

import PageObject.page.DashboardPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SearchHeroTest extends BaseTestData {
    private DashboardPage dashboardPage;

    @Before
    public void prepareTest() {
        prepareDriver();
        dashboardPage = new DashboardPage(driver, baseUrl);
        dashboardPage.navigateToDashboard();
    }

    @Test
    public void testSearchHero() {
        String foundHeroName = dashboardPage.searchHeroByName("Dyna");
        Assert.assertTrue(foundHeroName.toUpperCase().contains("DYNAMA"));
    }

    @After
    public void finishTest() {
        tearDown();
    }
}