package TestNG.Tabs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class tabs {

    private String url= "https://demoqa.com/links";
    WebDriver driver;

    @BeforeMethod
    public void setBaseUrl(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();

    }

    @Test(priority = 3)
    public void openNewTabUsingJS() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test(priority = 2)
    public void openNewTabCliking()throws InterruptedException{
        driver.findElement(By.id("simpleLink")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("dynamicLink")).click();
        Thread.sleep(5000);

        driver.get("https://www.google.com");

    }

    @Test(priority = 1)
    public void handleTabs()throws InterruptedException {
        String mainTab = driver.getWindowHandle();
        String newTab ;

        System.out.println("Main Tab: " + mainTab);

        driver.findElement(By.id("simpleLink")).click();
        Thread.sleep(5000);

        Set<String> handles = driver.getWindowHandles();

        for(String actual : handles){
            System.out.println("-- Handled id -- " + actual);

            if(!actual.equalsIgnoreCase(mainTab)){
                System.out.println("-- Changing Tab --");
                newTab = actual;
                driver.switchTo().window(newTab);

            }
        }

        driver.get("https://www.google.com/");
        Thread.sleep(5000);
        System.out.println("-- Changing Tab --");

        driver.switchTo().window(mainTab);
        driver.get("https://www.google.com/");
        Thread.sleep(5000);

    }

    @AfterMethod
    public void closeSession(){
        driver.quit();
    }

}
