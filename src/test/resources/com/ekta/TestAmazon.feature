Feature: Test Amazon Web Application

  Scenario: Launch app and login to application
    Given Open the Browser
    And Enter Amazon App URL
    And Click Sign In Button
    And Enter username and password
    Then User should be logged in successfully

  Scenario: Search Departments and select Electronics Item
    When Go to Electronics Menu in Departments Section
    And Click HeadPhones and select first HeadPhone in list
    And Add default quantity and Add to Cart
    Then Headphone should be added to Cart

  Scenario: Search MacBook Pro
    When Enter MacBook Pro in Search Bar
    And Select Product from list
    And Add two MacBook to Cart
    Then Macbook should be added to Cart

  Scenario: Remove HeadPhone and reduce MacBook in quantity
    When Delete HeadPhone from Cart and reduce macbook qty
    Then Proceed to Checkout and close




