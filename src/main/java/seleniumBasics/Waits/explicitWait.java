package seleniumBasics.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class explicitWait {
    //permite esperar por condiciones  esperadas +inteligente
    //polling time 250 ms

    public static void main( String [] args) {

        String url = "https://demoqa.com/dynamic-properties";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get(url);
        driver.manage().window().maximize();

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
            WebElement button = driver.findElement(By.id("visibleAfter"));
            button.click();
            System.out.println("Boton clickeado.");
        }catch (Exception e){
            System.out.println(e);
        }


        driver.quit();

    }

}
