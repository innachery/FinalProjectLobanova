package pageObjects;

import org.example.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    WebElement emailAddressInput = driver.findElement(By.xpath("//input[@name=\"emailAddress\"]"));
    WebElement phonePrefixCombobox = driver.findElement(By.xpath("//div[@id=\"phonePrefix\"]//span"));
    WebElement searchPhonePrefix = driver.findElement(By.id("PL"));
    WebElement phoneNumberInput = driver.findElement(By.xpath("//input[@name=\"delivery-telephone\"]"));

    WebElement totalField = driver.findElement(By.xpath("//dd[@class=\"text-right total-price\"]"));
    WebElement deliveryCostField = driver.findElement(By.xpath("//strong[text()='FREE']"));
    WebElement subTotalField = driver.findElement(By.xpath("//dd[@class=\"item-price text-right\"]"));

    WebElement enterAddressManuallyButton = driver.findElement(By.id("delivery-manualEntryDeliveryAddress"));
    WebElement fullNameInput = driver.findElement(By.id("delivery-fullName"));
    WebElement addressLine1Input = driver.findElement(By.id("delivery-addressLine1"));
    WebElement townCityInput = driver.findElement(By.id("delivery-city"));
    WebElement postcodeInput = driver.findElement(By.id("delivery-postCode"));
    WebElement cardNumberInput = driver.findElement(By.id("credit-card-number"));
    WebElement expireDateInput = driver.findElement(By.id("expiration"));
    WebElement cvvInput = driver.findElement(By.id("cvv"));
    WebElement buyNowButton = driver.findElement(By.id("buyNowButton"));
    WebElement checker = driver.findElement(By.xpath("//label[@class=\"checker\"]"));
    WebElement errorMessage = driver.findElement(By.xpath("//div[@class=\"buynow-error-msg\"]"));

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterEmailAndPhoneNumber(String email, String number) {
        emailAddressInput.sendKeys(email);
        phonePrefixCombobox.click();
        searchPhonePrefix.click();
        phoneNumberInput.sendKeys(number);
        return this;
    }

    public String deliveryCost() {
        String actualDeliveryCost = deliveryCostField.getText();
        return actualDeliveryCost;
    }

    public String subtotal() {
        String actualSubtotal = subTotalField.getText();
        return actualSubtotal;
    }

    public String total() {
        String actualTotal = totalField.getText();
        return actualTotal;
    }

    public CheckoutPage enterAddressManually(String fullName, String address, String town, String postcode) {
        enterAddressManuallyButton.click();
        fullNameInput.sendKeys(fullName);
        addressLine1Input.sendKeys(address);
        townCityInput.sendKeys(town);
        postcodeInput.sendKeys(postcode);
        return this;

    }

    public CheckoutPage enterCardDetails(String cardNumber, String expireDate, String cvv) {
        cardNumberInput.sendKeys(cardNumber);
        expireDateInput.sendKeys(expireDate);
        cvvInput.sendKeys(cvv);
        return this;
    }

    public boolean checkerIsPressed() {
        checker.isSelected();
        return true;
    }
    public CheckoutPage buyTheBook(){
        buyNowButton.click();
        return this;
    }
    public boolean errorMassageIsDisplayed(){
        errorMessage.isDisplayed();
        return true;
    }
}
