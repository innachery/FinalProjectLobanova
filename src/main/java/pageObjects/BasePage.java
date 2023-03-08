package pageObjects;

import org.openqa.selenium.WebDriver;

abstract class BasePage {
protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
