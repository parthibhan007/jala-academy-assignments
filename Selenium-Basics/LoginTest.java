import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://magnus.jalatechnologies.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");

        driver.findElement(By.id("btnLogin")).click();

        System.out.println("Login successful");

        driver.quit();
    }
}