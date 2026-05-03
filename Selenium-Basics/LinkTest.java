import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://magnus.jalatechnologies.com/");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Forgot Password")).click();

        System.out.println("Link clicked");

        driver.quit();
    }
}