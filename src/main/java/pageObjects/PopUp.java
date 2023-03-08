package pageObjects;

import org.example.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUp extends BasePage {
    WebElement basketCheckoutButton = driver.findElement(By.xpath("//span[@id=\"basket-total-cost\"]//following-sibling::a[2]"));

    public PopUp(WebDriver driver) {
        super(driver);
    }

    public BasketPage goToBasket(){
        basketCheckoutButton.click();
        return new BasketPage(driver);
    }
}
