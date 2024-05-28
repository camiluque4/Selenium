package Dropdowns;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class oldStyleDropdown {

    public static void main(String [] args){

        String url = "https://demoqa.com/select-menu";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();

        //declarar el objeto de UI select

        Select oldStyleMenu = new Select(driver.findElement(By.id("oldSelectMenu")));

        //por indice
        //oldStyleMenu.selectByIndex(1);

        //por value
        //oldStyleMenu.selectByValue("8");

        //por texto
        oldStyleMenu.selectByVisibleText("Magenta");

        driver.quit();




        }

    }


