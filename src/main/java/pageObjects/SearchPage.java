package pageObjects;

import org.example.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends BasePage {
    WebElement searchResults = driver.findElement(By.tagName("h1"));
    List<WebElement> booksMatchingTheSearch = driver.findElements(By.xpath("//h3//a"));
    List<WebElement> listOfBooksAfterFilters = driver.findElements(By.xpath("//h3//a"));
    WebElement addToBasket = driver.findElement(By.xpath("//a[@data-price=\"66.00\"]"));

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void iAmOnTheSearchPage() {
        searchResults.isDisplayed();
    }

    public List<String> getTheListOfBooks() {
        List<String> booksList = booksMatchingTheSearch.stream().map(book -> book.getText()).collect(Collectors.toList());
        return booksList;
    }
    public List<String> getTheListOfBooksAfterFilters() {

        List<String> actualListOfBooks = listOfBooksAfterFilters.stream().map(list -> list.getText()).collect(Collectors.toList());
        return actualListOfBooks;


    }
    public PopUp addBookToTheBasket(){
        addToBasket.click();
        return new PopUp(driver);
    }
}
