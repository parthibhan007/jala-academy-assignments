import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBoxTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://magnus.jalatechnologies.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("UserName")).sendKeys("testuser");

        String value = driver.findElement(By.id("UserName")).getAttribute("value");
        System.out.println("Textbox value: " + value);

        driver.findElement(By.id("UserName")).clear();

        boolean enabled = driver.findElement(By.id("UserName")).isEnabled();
        System.out.println("Textbox enabled: " + enabled);

        driver.quit();
    }
}