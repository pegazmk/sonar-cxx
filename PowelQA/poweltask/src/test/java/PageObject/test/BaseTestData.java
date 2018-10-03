package PageObject.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTestData {

    protected WebDriver driver;
    protected String baseUrl;

    protected void prepareDriver()
    {

        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver");

        driver = new ChromeDriver();
        baseUrl = "http://localhost:4200";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    protected void tearDown()
    {
        driver.quit();
    }
}
