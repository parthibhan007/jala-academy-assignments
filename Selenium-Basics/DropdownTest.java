import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://magnus.jalatechnologies.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        driver.findElement(By.id("btnLogin")).click();

        // Example dropdown (update ID based on actual page)
        try {
            Select dropdown = new Select(driver.findElement(By.id("Country")));
            dropdown.selectByVisibleText("India");
            System.out.println("Dropdown selected");
        } catch (Exception e) {
            System.out.println("Dropdown not found on page");
        }

        driver.quit();
    }
}