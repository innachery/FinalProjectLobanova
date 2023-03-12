package pageObjects;

import org.example.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilterForm extends BaseClass {
    WebElement priceRangeCombobox = driver.findElement(By.id("filterPrice"));
    WebElement priceFilter = driver.findElement(By.xpath("//option[@value=\"high\"]"));
    WebElement availabilityCombobox = driver.findElement(By.id("filterAvailability"));
    WebElement availabilityFilter = driver.findElement(By.xpath("//option[@label=\"In Stock (5)\"]"));
    WebElement languageCombobox = driver.findElement(By.id("filterLang"));
    WebElement languageFilter = driver.findElement(By.xpath("//option[@label=\"English (17)\"]"));
    WebElement formatCombobox = driver.findElement(By.id("filterFormat"));
    WebElement formatFilter = driver.findElement(By.xpath("//option[@label=\"Paperback (22)\"]"));
    WebElement refineResultsButton = driver.findElement(By.xpath("//button[contains(text(),'Refine results')]"));


    public SearchPage applyFilters() {
        priceRangeCombobox.click();
        priceFilter.click();
        availabilityCombobox.click();
        availabilityFilter.click();
        formatCombobox.click();
        formatFilter.click();
        refineResultsButton.click();
        return new SearchPage();
    }

    public String getPriceFilter() {
        String actualPriceFilter = priceFilter.getText();
        return actualPriceFilter;

    }

    public String getAvailabilityFilter() {
        String actualAvailabilityFilter = availabilityFilter.getText();
        return actualAvailabilityFilter;
    }

    public String getLanguageFilter() {
        String actualLanguageFilter = languageFilter.getText();
        return actualLanguageFilter;
    }

    public String getFormatFilter() {
        String actualFormatFilter = formatFilter.getText();
        return actualFormatFilter;
    }
}


