import org.junit.After;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static javafx.scene.paint.Color.rgb;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;

public class Task6 {

    private WebDriver drvChrome;
    private WebDriverWait wait;
    private String baseURL = "http://localhost/litecart/admin";

    @Before
    public void task5Cart_setup() {

        System.out.println("Task6 is Started");

        WebDriverManager.chromedriver().setup();
        drvChrome = new ChromeDriver();

        wait = new WebDriverWait(drvChrome, 20);
        drvChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriver.Timeouts pageLoadTimeout = drvChrome.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        drvChrome.manage().window().maximize();
        performLogin();
    }

    @After
    public void taskt5Cart_cleanup() {
        //drvChrome.quit();
        System.out.println("Tests6 is Finished");
    }

    private void performLogin() {
        //By sidebar = By.id("sidebar");

        drvChrome.navigate().to(baseURL);

        // if (isElementPresent(sidebar)) return;

        //  wait.until(ExpectedConditions.presenceOfElementLocated(sidebar));
    }

    private boolean isElementPresent(By element) {
        return drvChrome.findElements(element).size() > 0;
    }


    @Test
    public <WebPageTimeoutException> void task6_windows() {


    }


    }
