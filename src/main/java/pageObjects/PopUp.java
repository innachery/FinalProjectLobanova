package pageObjects;

import org.example.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUp extends BaseClass {
    WebElement basketCheckoutButton = driver.findElement(By.xpath("//a[text()=\"Checkout\"][1]"));


    public BasketPage goToBasket() {
        basketCheckoutButton.click();
        return new BasketPage();
    }
}
