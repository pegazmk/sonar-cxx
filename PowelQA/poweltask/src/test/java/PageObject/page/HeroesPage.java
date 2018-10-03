package PageObject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeroesPage extends PageObject {

    String HeroesPageAddress = "/heroes";

    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-heroes[1]/div[1]/label[1]/input[1]")
    private WebElement addHeroEdit;

    @FindBy(xpath = "//button[contains(text(),'add')]")
    private WebElement addButton;

    public HeroesPage(WebDriver driver, String baseUrl) {
        super(driver, baseUrl);
    }

    /**
     * Navigates to Heroes page
     */
    public void navigateToHeroes() {
        String currentUrl = driver.getCurrentUrl();
        if(!currentUrl.contains(HeroesPageAddress)) {
            driver.navigate().to(baseUrl + HeroesPageAddress);
        }
    }

    /**
     * Adds hero
     * @param Name new hero name
     */
    public void addHero(String Name) {
        addHeroEdit.sendKeys(Name);
        addButton.click();
    }

    /**
     * deletes hero
     * @param HeroName hero name
     */
    public void deleteHero(String HeroName) {
        WebElement heroButtonElement = driver.findElement(By.xpath("//a[contains(text(),'" + HeroName + "')]/../button"));
        heroButtonElement.click();
    }

    /**
     * Finds id of the hero on the hero list
     * @param HeroName name of searched hero
     * @return id of the hero, 0 if not found
     */
    public int getHeroId(String HeroName) {
        try {
            WebElement heroElement = driver.findElement(By.xpath("//a[contains(text(),'" + HeroName + "')]"));
            WebElement heroIndexElement = heroElement.findElement(By.xpath(".//span"));
            return Integer.parseInt(heroIndexElement.getText());
        } catch (NoSuchElementException e) {
            return 0;
        }
    }
}
