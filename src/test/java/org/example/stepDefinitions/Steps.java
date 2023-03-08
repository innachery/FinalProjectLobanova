package org.example.stepDefinitions;


import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import pageObjects.*;
import io.cucumber.java.en.*;
import org.example.BaseClass;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class Steps {

    WebDriver driver;

    @Given("I am an anonymous customer with clear cookies")
    public void i_am_an_anonymous_customer_with_clear_cookies() {
        driver.get("https://www.bookdepository.com/");
    }

    @And("I open the Initial home page")
    public void i_open_the_initial_home_page() {
        HomePage homePage = new HomePage(driver);
        String expectedPageName = "\tBook Depository: Free delivery worldwide on over 20 million books";
        Assert.assertEquals(expectedPageName, homePage.getPageName());
    }

    @And("I search for {string}")
    public void i_search_for(String name) {
        HomePage homePage = new HomePage(driver);
        homePage.searchTheBook("Thinking in Java");
    }

    @And("I am redirected to Search Page")
    public void i_am_redirected_to_search_page() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.iAmOnTheSearchPage();

    }

    @And("Search results contain the following products")
    public void search_results_contain_the_following_products(String name1, String name2, String name3) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.getTheListOfBooks();
        List<String> expectedBooksList = Arrays.asList("Thinking in Java ", "Thinking Java Part I ", "Core Java Professional");
        Assert.assertTrue(searchPage.getTheListOfBooks().containsAll(expectedBooksList));
    }

    @And("I apply the following search filters")
    public void i_apply_the_following_search_filters() {
        FilterForm filterForm = new FilterForm(driver);
        filterForm.applyFilters();
    }

    @And("Search results contain only the following products")
    public void search_results_contain_only_the_following_products(String name1, String name2, String name3, String name4) {
        SearchPage searchPage = new SearchPage(driver);
        List<String> expectedBooksListAfterFilters = Arrays.asList("Thinking in Java ", "Think Java ", "Thinking Recursively - A 20th Anniversary", "Think Data Structures");
        Assert.assertTrue(searchPage.getTheListOfBooksAfterFilters().containsAll(expectedBooksListAfterFilters));
    }

    @And("I click {string} button for product with name {string}")
    public void i_click_button_for_product_with_name(String name) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.addBookToTheBasket();


    }

    @And("I select {string} in basket pop-up")
    public void i_select_in_basket_pop_up() {
        PopUp popUp = new PopUp(driver);
        popUp.goToBasket();

    }

    @And("I am redirected to a {string}")
    public void i_am_redirected_to_a_basket() {
        BasketPage basketPage = new BasketPage(driver);
        basketPage.iAmOnTheBasketPage();


    }

    @And("Basket order summary is as following:")
    public void basket_order_summary_is_as_following() {
        BasketPage basketPage = new BasketPage(driver);
        Assert.assertEquals(basketPage.deliveryCost(), "FREE");
        Assert.assertEquals(basketPage.totalPrice(), "66,00 €");

    }

    @And("I click {string} button on {string} page")
    public void i_click_button_on_page() {
        BasketPage basketPage = new BasketPage(driver);
        basketPage.goToCheckoutPage();

    }

    @And("I checkout as a new customer with email {string}")
    public void i_checkout_as_a_new_customer_with_email() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterEmailAndPhoneNumber("test@user.com", "452699442");

    }

    @And("Checkout order summary is as following:")
    public void checkout_order_summary_is_as_following() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertEquals(checkoutPage.deliveryCost(), "FREE");
        Assert.assertEquals(checkoutPage.subtotal(), "66,00 €");
        Assert.assertEquals(checkoutPage.total(), "66,00 €");

    }

    @And("I fill delivery address information manually:")
    public void i_fill_delivery_address_information_manually() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterAddressManually("INNA LOBANOVA", "Ogrody, 11/57", "Bydgoszcz", "85-870 ");
    }

    @And("I enter the details of the card that does not have enough money")
    public void i_enter_the_details_of_the_card_that_does_not_have_enough_money() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCardDetails("1111111111111111", "01/25", "152");
    }

    @And("Checkbox {string} is pressed")
    public void checkbox_is_pressed() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.checkerIsPressed());

    }

    @When("I press {string} button")
    public void i_press_button() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.buyTheBook();


    }

    @Then("I do not place the order")
    public void i_do_not_place_the_order() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.errorMassageIsDisplayed());

    }


    @And("I apply the following search filters:")
    public void iApplyTheFollowingSearchFilters() {
    }
}
