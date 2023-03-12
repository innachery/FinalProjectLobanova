package org.example.stepDefinitions;


import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.*;
import io.cucumber.java.en.*;
import org.example.BaseClass;
import org.junit.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Steps extends BaseClass {


    @Given("I am an anonymous customer with clear cookies")
    public void i_am_an_anonymous_customer_with_clear_cookies() {
        initializeDriver();
        driver.get("https://www.bookdepository.com/");
        HomePage homePage = new HomePage();

    }

    @And("I open the Initial home page")
    public void i_open_the_initial_home_page() {
        CookiesPage cookiesPage = new CookiesPage();
        cookiesPage.acceptCookies();
        HomePage homePage = new HomePage();
        homePage.selectCurrencyEur();

        //    HomePage homePage = new HomePage();

        //   String expectedPageName = "\tBook Depository: Free delivery worldwide on over 20 million books";
        //   Assert.assertEquals(expectedPageName, homePage.getPageName());
    }

    @And("I search for {string}")
    public void i_search_for(String name) {
        HomePage homePage = new HomePage();
        homePage.searchTheBook("Thinking in Java");

    }

    @And("I am redirected to Search Page")
    public void i_am_redirected_to_search_page() {
        SearchPage searchPage = new SearchPage();
        searchPage.iAmOnTheSearchPage();

    }

    @And("Search results contain the following products:")
    public void search_results_contain_the_following_products(DataTable dataTable) {
        SearchPage searchPage = new SearchPage();
        searchPage.getTheListOfBooks();
        List<String> expectedBooksList = new ArrayList<>();
        expectedBooksList.add(dataTable.cell(0, 0));
        expectedBooksList.add(dataTable.cell(1, 0));
        expectedBooksList.add(dataTable.cell(2, 0));
        Assert.assertTrue(searchPage.getTheListOfBooks().containsAll(expectedBooksList));
    }

    @And("I apply the following search filters")
    public void i_apply_the_following_search_filters(DataTable dataTable) {
        FilterForm filterForm = new FilterForm();
        Assert.assertEquals(filterForm.getPriceFilter(), dataTable.cell(0, 1));
        Assert.assertEquals(filterForm.getAvailabilityFilter(), dataTable.cell(1, 1));
        Assert.assertEquals(filterForm.getLanguageFilter(), dataTable.cell(2, 1));
        filterForm.applyFilters();
    }

    @And("Search results contain only the following products")
    public void search_results_contain_only_the_following_products(DataTable dataTable) {
        SearchPage searchPage = new SearchPage();
        List<String> expectedBooksListAfterFilters = new ArrayList<>();
        expectedBooksListAfterFilters.add(dataTable.cell(0, 0));
        expectedBooksListAfterFilters.add(dataTable.cell(1, 0));
        expectedBooksListAfterFilters.add(dataTable.cell(2, 0));
        expectedBooksListAfterFilters.add(dataTable.cell(3, 0));
        for (int i = 0; i < searchPage.getTheListOfBooks().size(); i++) {
            for (int j = 0; j < expectedBooksListAfterFilters.size(); j++) {
                if (searchPage.getTheListOfBooks().get(i).equals(expectedBooksListAfterFilters.get(j)) == true) {
                    System.out.println("Элемент " + i +
                            " первого массива равен элементу " + j + " второго массива.");
                } else {
                    System.out.println("Элемент " + i +
                            " первого массива не равен элементу " + j + " второго массива.");
                }
            }
        }
    }

    @And("I click Add to Basket button for product with name Thinking in Java")
    public void i_click_button_for_product_with_name() {
        SearchPage searchPage = new SearchPage();
        searchPage.addBookToTheBasket();


    }

    @And("I select Basket Checkout in basket pop-up")
    public void i_select_basket_checkout_in_basket_pop_up() {
        PopUp popUp = new PopUp();
        popUp.goToBasket();

    }

    @And("I am redirected to a Basket Page")
    public void i_am_redirected_to_a_basket_page() {
        BasketPage basketPage = new BasketPage();
        basketPage.iAmOnTheBasketPage();


    }

    @And("Basket order summary is as following:")
    public void basket_order_summary_is_as_following(DataTable dataTable) {
        BasketPage basketPage = new BasketPage();

        Assert.assertEquals(basketPage.deliveryCost(), dataTable.cell(0, 1));
        Assert.assertEquals(basketPage.totalPrice(), dataTable.cell(1, 1));

    }

    @And("I click Checkout button on Basket page")
    public void i_click_checkout_button_on_basket_page() {
        BasketPage basketPage = new BasketPage();
        basketPage.goToCheckoutPage();

    }

    @And("I checkout as a new customer with email and phone number")
    public void i_checkout_as_a_new_customer_with_email_and_phone_number(DataTable dataTable) {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.enterEmailAndPhoneNumber(dataTable.cell(0, 0), dataTable.cell(1, 0));

    }

    @And("Checkout order summary is as following:")
    public void checkout_order_summary_is_as_following() {
        CheckoutPage checkoutPage = new CheckoutPage();
        Assert.assertEquals(checkoutPage.deliveryCost(), "FREE");
        Assert.assertEquals(checkoutPage.subtotal(), "66,00 €");
        Assert.assertEquals(checkoutPage.total(), "66,00 €");

    }

    @And("I fill delivery address information manually:")
    public void i_fill_delivery_address_information_manually() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.enterAddressManually("INNA LOBANOVA", "Ogrody, 11/57", "Bydgoszcz", "85-870 ");
    }

    @And("I enter the details of the card that does not have enough money")
    public void i_enter_the_details_of_the_card_that_does_not_have_enough_money() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.enterCardDetails("1111111111111111", "01/25", "152");
    }

    @And("Checkbox {string} is pressed")
    public void checkbox_is_pressed() {
        CheckoutPage checkoutPage = new CheckoutPage();
        Assert.assertTrue(checkoutPage.checkerIsPressed());

    }

    @When("I press {string} button")
    public void i_press_button() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.buyTheBook();


    }

    @Then("I do not place the order")
    public void i_do_not_place_the_order() {
        CheckoutPage checkoutPage = new CheckoutPage();
        Assert.assertTrue(checkoutPage.errorMassageIsDisplayed());

    }


    @And("I apply the following search filters:")
    public void iApplyTheFollowingSearchFilters() {
    }
}
