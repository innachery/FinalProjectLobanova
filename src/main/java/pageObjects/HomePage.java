package pageObjects;

import org.example.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseClass {
    WebElement searchField = driver.findElement(By.xpath("//input[@class=\"text-input\"]"));
    WebElement searchButton = driver.findElement(By.xpath("//button[@aria-label=\"Search\"]"));
    WebElement pageName = driver.findElement(By.tagName("title"));
    WebElement currency = driver.findElement(By.xpath("//div[@class=\"right-section\"]//select[@id=\"selectCurrency\"]"));
    WebElement selectEur = driver.findElement(By.xpath("//div[@class=\"right-section\"]//select[@id=\"selectCurrency\"]//option[@value=\"EUR\"]"));
    public HomePage selectCurrencyEur(){
        currency.click();
        selectEur.click();
        return this;
    }




    public String getPageName() {
        String actualPageName = pageName.getText();
        return actualPageName;
    }

    public SearchPage searchTheBook(String name) {
        searchField.sendKeys(name);
        searchButton.click();
        return new SearchPage();
    }
}
