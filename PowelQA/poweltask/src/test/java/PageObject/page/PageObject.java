package PageObject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    protected WebDriver driver;
    protected String baseUrl;

    public PageObject(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
        PageFactory.initElements(driver, this);
    }

}
