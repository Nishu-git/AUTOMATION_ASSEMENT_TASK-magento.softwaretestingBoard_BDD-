Feature: User Registration

  Scenario: Create a new customer account
  
    Given user opens the browser
   Given the user click on the sign up button and redirects to sign up page
    When the user enters the following personal information:
      | First Name | Last Name|
      | Nishu       | Singh  |
    And the user enters the following sign-in information:
      | Email                     |  Password     |Confirm Password|
      |nishu.15101singh@gmail.com | LuMA**21##    | LuMA**21##     |
      
    And the user clicks on the "Create an Account" button
    Then the user should see a confirmation message "Thank you for registering with Magento."
