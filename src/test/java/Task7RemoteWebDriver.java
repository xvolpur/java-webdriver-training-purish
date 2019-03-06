import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;


public class Task7RemoteWebDriver {

    private String baseURL = "http://localhost/litecart";
    private String username = "admin";
    private String password = "admin";
    private WebDriverWait wait;

    RemoteWebDriver driver;

    @Before
    public void start() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browserName", "chrome");

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
    }

    @After
    public void stop() {  driver.quit();   }


    public static class EventsListener extends AbstractWebDriverEventListener {    }

    private boolean isElementPresent(By element) {
        return driver.findElements(element).size() > 0;
    }


    @Test
    public void localSeleniumDriver() {


        wait = new WebDriverWait(driver, 5);
        driver.get(baseURL + "/admin");

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);

        driver.findElement(By.name("login")).click();

    }

}

