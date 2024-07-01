package TestNG.Introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

//ventajas: generacion de reportes
//agrupar test
//annotations
//priorizar
//testing paralelo


public class Introduction {

    private String url = "https://demoqa.com/";
    WebDriver driver;

    @BeforeTest
    public void setUrl() {

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(url);

    }

    @Test
    public void titleTest() {
        String expectedTitle = "DEMOQA";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void urlTest() {
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, url);

    }

    @AfterTest
    public void closeSession(){
        driver.quit();
    }


}
