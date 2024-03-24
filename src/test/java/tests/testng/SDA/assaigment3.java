package tests.testng.SDA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class assaigment3  extends Tests{
    /* go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!"
*/
    @Test
    public void softassert(){
       bot.navigate("https://practicetestautomation.com/practice-test-login/");
        SoftAssert softAssert=new SoftAssert();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("incorrectPassword");
        WebElement loginButton = driver.findElement(By.id("submit"));
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.id("error"));
        softAssert.assertTrue(errorMessage.isDisplayed(), "Error message is not shown");
        String expectedErrorMessage = "Your password is invalid!";
        String actualErrorMessage = errorMessage.getText();
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message text is incorrect");
        softAssert.assertAll();
    }
//        By username= By.id("username");
//        driver.findElement(username).sendKeys("student");
//        By password=By.id("password");
//        driver.findElement(password).sendKeys("incorrectPassword");
//        By loginButton=By.id("submit");
//        driver.findElement(loginButton).click();

        // Assert that the error message text is "Your password is invalid!"

}
