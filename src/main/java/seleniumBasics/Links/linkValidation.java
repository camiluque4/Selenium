package seleniumBasics.Links;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.List;

public class linkValidation {

    public static void main(String [] args) {

        String url = "https://demoqa.com/broken";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();

        WebElement validLink = driver.findElement(By.xpath("//*[contains(text(),'Click Here for Valid Link')]"));
        WebElement invalidLink = driver.findElement(By.xpath("//*[contains(text(),'Click Here for Broken Link')]"));

        HttpURLConnection http = null;
        int codigoRespuesta = 200;
        String src = "";

        //src = validLink.getAttribute("href");
        src = invalidLink.getAttribute("href");

        System.out.println("Validando este src: " + src);

        try{
            http = (HttpURLConnection) (new URL(src).openConnection());
            http.setRequestMethod("HEAD");
            http.connect();

            codigoRespuesta = http.getResponseCode();
            System.out.println(codigoRespuesta);

            if (codigoRespuesta >= 400 ){
                System.out.println(src + " is a broken Link");
            }else {
                System.out.println(src + " is NOT a broken Link");
            }


        }catch (Exception e){
            System.out.println("Error" + e);
        }

        System.out.println("----------------------TODOS LOS LINKS-------------------------");

        List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
        Iterator<WebElement> links = listOfLinks.iterator();

        while(links.hasNext()){

            System.out.println("----------------probando A tag----------------");

            src = links.next().getAttribute("href");

            if(src == null ||src.isEmpty()){
                System.out.println("la url no esta asignada o es un valor nulo");
                continue;
            }
            try{
                http = (HttpURLConnection) (new URL(src).openConnection());
                http.setRequestMethod("HEAD");
                http.connect();

                codigoRespuesta = http.getResponseCode();
                System.out.println(codigoRespuesta);

                if (codigoRespuesta >= 400 ){
                    System.out.println(src + " is a broken Link");
                }else {
                    System.out.println(src + " is NOT a broken Link");
                }


            }catch (Exception e){
                System.out.println("Error" + e);
            }

        }
        System.out.println("----------------todos los links probados----------------");

        driver.quit();

    }
}
