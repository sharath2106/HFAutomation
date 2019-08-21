Feature: Checkout product from the application by a new user

  Scenario: Login to the application after SignUp

    Given I land on the home page and click on Sign In button
    When I login with the a username and password
    Then I should land on the registered user page

  Scenario: Sign up a new user to the application

    Given I land on the home page and click on Sign In button
    When I create a new account for the new user
    Then I should land on the new user page
    Then I should enter the personal details of the user
    Then I should enter the address and phone number of the user
    Then I should register the user
    Then I should land on the registered user page
