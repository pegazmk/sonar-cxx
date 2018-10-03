package PageObject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends PageObject {

    private String DashboardPageAddress = "/dashboard";

    @FindBy(id = "search-box")
    private WebElement SearchBoxEdit;

    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-dashboard[1]/app-hero-search[1]/div[1]/ul[1]/li[1]/a[1]")
    private WebElement FoundHero1stOnList;

    public DashboardPage(WebDriver driver, String baseUrl) {
        super(driver, baseUrl);
    }

    /**
     * Navigates to dashboard page
     */
    public void navigateToDashboard() {
        String currentUrl = driver.getCurrentUrl();
        if(!currentUrl.contains(DashboardPageAddress)) {
            driver.navigate().to(baseUrl + DashboardPageAddress);
        }
    }

    /**
     * Clicks on Top Hero button, found by hero name
     * @param HeroName hero name on the button
     */
    public void clickOnTopHero(String HeroName)
    {
        WebElement element = driver.findElement(By.xpath("//h4[contains(text(),'" + HeroName + "')]"));
        element.click();
    }

    /**
     * Gets the name of Top Hero - button caption
     * @param HeroIndex 1-based button index
     * @return Name of Hero
     */
    public String getTopHeroName(int HeroIndex)
    {
        WebElement element = driver.findElement(By.xpath("//app-dashboard[1]/div[1]/a[" + Integer.toString(HeroIndex) + "]/div[1]"));
        return element.getText();
    }

    /**
     * Clicks on the Top Hero button
     * @param HeroIndex 1-based button index
     */
    public void clickOnTopHero(int HeroIndex)
    {
        WebElement element = driver.findElement(By.xpath("//app-dashboard[1]/div[1]/a[" + Integer.toString(HeroIndex) + "]/div[1]/h4[1]"));
        element.click();
    }

    /**
     * Returns details of the hero (after click)
     * @return Text with hero details
     */
    public String getDetailsData()
    {
        WebElement element = driver.findElement(By.xpath("//app-hero-detail[1]/div[1]/h2[1]"));
        return element.getText();
    }

    /**
     * Looks for hero by name and returns 1st element on result list
     * @param HeroName name to look for, can be part of it
     * @return 1st element on result list
     */
    public String searchHeroByName(String HeroName) {
        SearchBoxEdit.sendKeys(HeroName);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(FoundHero1stOnList));
        return FoundHero1stOnList.getText();
    }

}
