package tests.testng.SDA;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class assaignment2Exel extends Tests {
    @Test(dataProvider = "Excel")
    public void dataTest(String Country, String Area) {
        bot.navigate("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");
        WebElement title=driver.findElement(By.id("note-title-input"));
        title.sendKeys(Country);
        WebElement Details=driver.findElement(By.id("note-details-input"));
        Details.sendKeys(Area);
        WebElement Button=driver.findElement(By.id("add-note"));
        Button.click();
    }
    @DataProvider(name = "Excel")
    public Object[][] getData() throws IOException {
        Object[][] data = new Object[10][2];

        String fpath = "C:\\Users\\Bashair\\IdeaProjects\\assaignment2Ramdan\\src\\test\\resources\\testData\\excelfile.xlsx";
        FileInputStream path = new FileInputStream(fpath);
        Workbook workbook = WorkbookFactory.create(path);
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 0; i < 10; i++) {
            data[i][0] = sheet.getRow(i).getCell(0).toString();
            data[i][1] = sheet.getRow(i).getCell(1).toString();
        }
        workbook.close();
        path.close();
        return data;
    }}