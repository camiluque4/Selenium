package seleniumBasics.Waits;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
//import java.util.NoSuchElementException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class fluentWait {
    //podemos especificar cantidad de tiempo maximo de espera
    //podemos especificar Polling time(peticiones)
    //podemos especificar evitar una excepcion

    public static void main(String[] args){

        String url = "https://demoqa.com/dynamic-properties";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        driver.get(url);
        driver.manage().window().maximize();

        try{
            WebElement button = wait.until(new Function<WebDriver, WebElement>(){
                public WebElement apply(WebDriver driver){
                    return driver.findElement(By.id("visibleAfter"));
                }
            });

            button.click();
            System.out.println("boton clickeado");
        }catch(Exception e){
            System.out.println(e);
        }



        driver.quit();

    }

}
