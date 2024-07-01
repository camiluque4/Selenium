package seleniumBasics.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class implicitWait {

    //indica al webdriver que espere x cantidad de tiempo antes de que
    //aparezca la excepcion: No Such Element Exception

    //AUMENTA EL TIEMPO DE EJECUCION: hace que cada comando espere el
    //tiempo definido.

    public static void main(String [] args ){

        String url = "https://demoqa.com/dynamic-properties";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        driver.get(url);
        driver.manage().window().maximize();

        try{
            WebElement button = driver.findElement(By.id("visibleAfter"));
            button.click();
            System.out.println("Boton clickeado.");
        }catch (Exception e){
            System.out.println(e);
        }


        driver.quit();



    }


}
