package StepDefinations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class LUMA_SignUp {
    WebDriver driver;

  
  
        @Given("user opens the browser")
        public void user_opens_the_browser() {
           
            driver = new ChromeDriver();
        }

        @Given("the user click on the sign up button and redirects to sign up page")
        public void the_user_click_on_the_sign_up_button_and_redirects_to_sign_up_page() {
        	driver.manage().window().maximize();
            driver.get("https://magento.softwaretestingboard.com");
            WebElement signUpButton = driver.findElement(By.linkText("Create an Account"));
            signUpButton.click();
        }

        @When("the user enters the following personal information:")
        public void the_user_enters_personal_information(io.cucumber.datatable.DataTable dataTable) {
            java.util.List<java.util.Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            driver.findElement(By.id("firstname")).sendKeys(data.get(0).get("First Name"));
            driver.findElement(By.id("lastname")).sendKeys(data.get(0).get("Last Name"));
        }

        @When("the user enters the following sign-in information:")
        public void the_user_enters_signin_information(io.cucumber.datatable.DataTable dataTable) {
            java.util.List<java.util.Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            driver.findElement(By.id("email_address")).sendKeys(data.get(0).get("Email"));
            driver.findElement(By.id("password")).sendKeys(data.get(0).get("Password"));
            driver.findElement(By.id("password-confirmation")).sendKeys(data.get(0).get("Confirm Password"));
        }

        @When("the user clicks on the {string} button")
        public void the_user_clicks_on_button(String button) {
            WebElement createAccountButton = driver.findElement(By.cssSelector("button[title='" + button + "']"));
            createAccountButton.click();
        }

        @Then("the user should see a confirmation message {string}")
        public void the_user_should_see_confirmation_message(String message) {
            WebElement confirmationMessage = driver.findElement(By.cssSelector(".message-success"));
            assertEquals(message, confirmationMessage.getText());
            driver.quit();
        }
    }
