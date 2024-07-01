package TestNG.WebDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestWDManager {

    private String url= "https://demoqa.com/radio-button";
    WebDriver driver;

    @BeforeMethod
    public void setBaseUrl(){
        //System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();

    }

    @Test
    public void validateTitle(){
        String expectedTitle = "DEMOQA";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @AfterMethod(alwaysRun = true)
    public void closeSession(){
        driver.quit();
    }

}
