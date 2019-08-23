Feature: Checkout product from the application by a new user

  Scenario: Login to the application after SignUp

    Given I land on the home page and click on Sign In button
    When I login with the a username and password
    Then I should land on the registered user page

  Scenario: Sign up a new user to the application

    Given I land on the home page and click on Sign In button
    When I create a new account for the new user
    Then I should land on the new user page
    And I should enter the personal details of the user
    And I should enter the address and phone number of the user
    And I should register the user
    Then I should land on the registered user page
#    Above step to be refactored

  Scenario: Purchase a product by new user

    Given I land on the home page and click on Sign In button
    When I login with the a username and password
    Then I should land on the registered user page
    Then I select Women dress from Women category
    Then I should add the product to the cart
    Then I should be able to Proceed to Checkout from the summary page
    Then I should be able to complete payment and verify the order confirmation



