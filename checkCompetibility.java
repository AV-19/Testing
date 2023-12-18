import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowserCompatibilityTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
      
        //For Chrome
        WebDriver chromeDriver = new ChromeDriver();
        performCompatibilityTest(chromeDriver, "Chrome");
        chromeDriver.quit();

        // For Firefox
        WebDriver firefoxDriver = new FirefoxDriver();
        performCompatibilityTest(firefoxDriver, "Firefox");
        firefoxDriver.quit();

        // For Safari
        WebDriver safariDriver = new SafariDriver();
        performCompatibilityTest(safariDriver, "Safari");
        safariDriver.quit();
    }

    public static void performCompatibilityTest(WebDriver driver, String browser) {
     driver.get("https://www.xyzwebapp.com");

        if (driver.findElement(By.id("loginButton")).isDisplayed()) {
            System.out.println("Login button is displayed on " + browser);
        } else {
            System.out.println("Login button is NOT displayed on " + browser);
        }

        String expectedTitle = "XYZ Web Application";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title is correct on " + browser);
        } else {
            System.out.println("Title is NOT correct on " + browser + ". Actual Title: " + actualTitle);
        }

        driver.close();
    }
}
