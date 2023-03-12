package pageObjects;

import org.example.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CookiesPage extends BaseClass {
    WebElement cookies = driver.findElement(By.xpath("//button[@class=\"btn btn-sm btn-yes\"]"));

    public HomePage acceptCookies(){
        cookies.click();
        return new HomePage();
    }
}
