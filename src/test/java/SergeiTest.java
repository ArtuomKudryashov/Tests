import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SergeiTest {
    private WebDriver driver;

    @BeforeMethod
    public  void setUp(){
       WebDriverManager.chromedriver().setup() ;

         driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void setDown(){driver.quit();}

    // Я хочу вбить слов table. И проверить что все товары которые нашлись есть слово table
    // в названии

    @Test

    public  void testSearches(){
        driver.get("https://www.webstaurantstore.com/");

        String text = "table";

        driver.findElement(By.id("searchval")).sendKeys(text +"\n");

        List<WebElement>itemList = driver.findElements(By.xpath("//a[@data-testid='itemDescription']"));
        for (int i = 0; i< itemList.size();i++){
            System.out.println(itemList.get(i));

            //Проверяем что в каждом из элементов есть слово table
            Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("table"));
        }
    }
    
}
