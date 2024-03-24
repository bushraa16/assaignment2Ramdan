package tests.testng.assaignment2Ramadan;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class assaignment5 extends Tests{

    //Go to URL: http://crossbrowsertesting.github.io/  (Done)
    //Click to To-Do App (Done)
    //Checking Box to do-4 and Checking Box to do-5 (Done)
    //If both clicks worked, then the following List should be have length 2.(Done)
    //Assert that this is correct(Done)
    //Assert that the to do we added is present in the list( done)
    //Archiving old todos( done)
    //If our archive link worked, then the following list should have length 4. (done)
    //Assert that this is true as well(done)
    //Doing Cross Browser Testing.(done)


    @Test
    public void testass(){
        bot.navigate("http://crossbrowsertesting.github.io/");
        WebElement ToDoList=driver.findElement(By.xpath("//a[contains(@href,'app')]"));
        ToDoList.click();
        WebElement todo4=driver.findElement(By.name("todo-4"));
        todo4.click();
        WebElement todo5=driver.findElement(By.name("todo-5"));
        todo5.click();
        By size = By.className("done-true");
        List<WebElement> myElements = driver.findElements(size);
            assertEquals(2,myElements.size());
        System.out.println("Yes the length is 2 ");
        WebElement todotext = driver.findElement(By.id("todotext"));
        WebElement addbutton = driver.findElement(By.id("addbutton"));
        todotext.sendKeys("we added is present in the list");
        addbutton.click();
        By text = By.xpath("//li[span='we added is present in the list']");
       assertTrue(driver.findElement(text).isDisplayed());
        WebElement clicks= driver.findElement(By.xpath("//a[contains(@href,'')]"));
        clicks.click();
        List<WebElement>list=driver.findElements(By.className("done-false"));
        assertTrue(list.size()>=4);
    }

}
