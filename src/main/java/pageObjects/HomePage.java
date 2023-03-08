package pageObjects;

import org.example.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    WebElement searchField = driver.findElement(By.xpath("//input[@class=\"text-input\"]"));
    WebElement searchButton = driver.findElement(By.xpath("//button[@aria-label=\"Search\"]"));
    WebElement pageName = driver.findElement(By.tagName("title"));

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getPageName(){
        String actualPageName = pageName.getText();
        return actualPageName;
    }
    public SearchPage searchTheBook(String name) {
        searchField.sendKeys(name);
        searchButton.click();
        return new SearchPage(driver);
    }
}
