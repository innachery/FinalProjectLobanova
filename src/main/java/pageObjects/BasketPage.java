package pageObjects;

import org.example.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage {
WebElement yourBasket = driver.findElement(By.tagName("h1"));
WebElement deliveryCostField = driver.findElement(By.xpath("//dd[text()='FREE']"));
WebElement totalField = driver.findElement(By.xpath("//dd[text()='66,00 €']"));
WebElement checkoutButton = driver.findElement(By.xpath("Checkout"));

    public BasketPage(WebDriver driver) {
        super(driver);
    }


    public void iAmOnTheBasketPage(){
    yourBasket.isDisplayed();
}

public String deliveryCost(){
   String actualDeliveryCost = deliveryCostField.getText();
   return actualDeliveryCost;
}
    public String totalPrice(){
        String actualtotalPrice = totalField.getText();
        return actualtotalPrice;
    }

    public CheckoutPage goToCheckoutPage(){
    checkoutButton.click();
    return new CheckoutPage(driver);
    }
}
