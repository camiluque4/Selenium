package seleniumBasics.DragAndDrop;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//#1 -Import Action y Actions
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class dragAndDrop {

    public static void main(String [] args) {

        String url = "https://demoqa.com/droppable";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();

        //#2 instanciar la clase Action
        Actions action = new Actions(driver);

        //#3 definir from and  to
        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));

        //#4 usar el metodo dragAndDrop
        //action.dragAndDrop(from, to).build().perform();

        //#5 tambien se pueden usar las propiedades X e Y
        action.dragAndDropBy(from,350,36).build().perform();



    }
}
