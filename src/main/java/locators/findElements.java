package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class findElements {

    public static void main(String [] args){

        String url = "https://www.saucedemo.com/v1/";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");

        //instanciamos webdriver
        WebDriver driver = new ChromeDriver();

        //ingresar a un website
        driver.get(url);

        //maximize
        driver.manage().window().maximize();

        //credenciales
        String username = "standard_user";
        String password = "secret_sauce";

        //
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println("cuantos elementos hemos encontrado " + inputs.size());

        for(int i = 0; i < inputs.size(); i++){
            if(i == 0){
                inputs.get(i).sendKeys(username);
            }
            else if (i == 1){
                inputs.get(i).sendKeys(password);
            }
            else{
                inputs.get(i).click();
            }
        }

        driver.quit();

    }

}
