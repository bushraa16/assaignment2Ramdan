package tests.testng.SDA;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class assaigment4  {
    WebDriver driver;
    //Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password: 123456789
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.
    @Test(dataProvider ="Search")
    public void Testapp(String searchPhone){
        driver=new ChromeDriver();
       driver.navigate().to("http://opencart.abstracta.us/index.php?route=account/login");
        WebElement email=driver.findElement(By.name("email"));
        WebElement Password=driver.findElement(By.name("password"));
        WebElement loginButtin=driver.findElement(By.xpath("//input[@value='Login']"));
        email.sendKeys("clarusway@gmail.com");
        Password.sendKeys("123456789");
        loginButtin.click();
        WebElement search=driver.findElement(By.name("search"));
        search.sendKeys(searchPhone);
        search.sendKeys(Keys.ENTER);
    }
    @DataProvider(name = "Search")
    public Object [][] dataprovider(){
        return new Object[][]{
                {"Mac"},{"iPad"},{"Samsung"}
    };}







}
