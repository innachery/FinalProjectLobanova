package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;

    public static void initializeDriver() {
        WebDriverManager.chromedriver().setup();
      //  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Алекс\\IdeaProjects\\first-maven\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bookdepository.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    public void closeBrowser() {
        driver.quit();
    }
}
