package Dropdowns;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class multipleSelectDropdown {

    public static void main(String [] args ){

        String url = "https://demoqa.com/select-menu";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();

        //declarar el objeto de UI select

        Select cars = new Select(driver.findElement(By.id("cars")));

        //por indice
        cars.selectByIndex(2);

        //por value
        cars.selectByValue("audi");

        //por texto
        cars.selectByVisibleText("Volvo");

        //deseleccionar all
        //cars.deselectAll();

        //deseleccionar por valor
        cars.deselectByValue("audi");




        driver.quit();

    }

}
