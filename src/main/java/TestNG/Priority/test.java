package TestNG.Priority;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test {

    private String url= "https://demoqa.com/links";
    WebDriver driver;

    @BeforeMethod
    public void setBaseUrl(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();

    }

    @Test(priority = 0)
    public void dMethod (){
        System.out.println("Soy el metodo D");
    }

    @Test(priority = 1)
    public void cMethod (){
        System.out.println("Soy el metodo C");
    }

    @Test(priority = 2)
    public void bMethod (){
        System.out.println("Soy el metodo B");
    }

    @Test(priority = 3)
    public void aMethod (){
        System.out.println("Soy el metodo A");
    }


    @AfterMethod
    public void closeSession(){
        driver.quit();
    }


}
