package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {

    public static void main(String [] args){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");

        //iniciar el webdriver
        WebDriver driver = new ChromeDriver();

        //abrir navegador
        driver.get("https://www.saucedemo.com/v1/");

        //maximizar la ventana
        driver.manage().window().maximize();

        //credenciales
        String usuario = "standard_user";
        String contrasenia = "secret_sauce";

        //localizar por id
        WebElement userInput = driver.findElement(By.id("user-name"));
        //WebElement passwordInput = driver.findElement(By.id("password"));
        //WebElement loginBtn = driver.findElement(By.id("login-button"));

        //locator by class name
        //WebElement loginBtn = driver.findElement(By.className("btn_action"));

        //locator by name
        WebElement passwordInput = driver.findElement(By.name("password"));

        //locator by Xpath
        //WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));

        //locator by css
        WebElement loginBtn = driver.findElement(By.cssSelector("input.btn_action"));


        //login
        userInput.sendKeys(usuario);
        passwordInput.sendKeys(contrasenia);
        loginBtn.click();


        //driver.quit();


    }

}
