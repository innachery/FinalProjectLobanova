Feature: Desktop Checkout for Guest User
  As a customer
  I want to be able to proceed to checkout
  So that I can specify my delivery and payment details and place the order

  Scenario: Proceed to checkout final review and place the order
    Given I am an anonymous customer with clear cookies
    And I open the Initial home page
    And I search for "Thinking in Java"
    And I am redirected to Search Page
    And Search results contain the following products:
      | Thinking in Java       |
      | Thinking Java Part I   |
      | Core Java Professional |
    And I apply the following search filters
      | Price range  | 30 € +       |
      | Availability | In stock(4)  |
      | Language     | English(4)   |
      | Format       | Paperback(4) |
    And Search results contain only the following products
      | Thinking in Java                          |
      | Think Java                                |
      | Thinking Recursively - A 20th Anniversary |
      | Think Data Structures                     |
    And I click Add to Basket button for product with name "Thinking in Java "
    And I select Basket Checkout in basket pop-up
    And I am redirected to a Basket Page
    And Basket order summary is as following:
      | Delivery cost | FREE    |
      | Total         | 66,00 € |
    And I click "Checkout" button on "Basket" page
    And I checkout as a new customer with email "test@user.com" and phone number "+48452699442"
    And Checkout order summary is as following:
      | Sub-total (incl. taxes) | Delivery | Total   |
      | 66,00 €                 | FREE     | 66,00 € |
    And I fill delivery address information manually:
      | Full name     | Address line 1 | Town/City | Postcode/ZIP |
      | INNA LOBANOVA | Ogrody, 11/57  | Bydgoszcz | 85-870       |
    And I enter the details of the card that does not have enough money
      | Card number      | Expiry Date | CVV |
      | 1111111111111111 | 01/25       | 152 |
    And Checkbox "My billing address is the same as my delivery address" is pressed
    When I press "Buy now" button
    Then I do not place the order and the error message is displayed



