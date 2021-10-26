import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainTest {
    private WebDriver driver;

    @BeforeMethod
     public void setUp(){
        System.setProperty("webdriver.chrome.driver","d:\\New_Course\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();



    }

    @AfterMethod
    public void setDown(){driver.quit();}

    @Test
    public void testSearches() throws InterruptedException {
        driver.get("http://automationpractice.com/");


        WebElement input = driver.findElement(By.id("search_query_top"));
        input.sendKeys("dress\n");

        WebElement result = driver.findElement(By.className("lighter"));
        Assert.assertEquals(result.getText(),"\"DRESS\"");

        Thread.sleep(4600);



    }
}
