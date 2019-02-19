import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.NoSuchElementException;

public class litecart2Section {

    private WebDriver drvChrome;
    private String driverPathChrome = "D:/Projects/chromedriver.exe";

    @Before
    public void litecartTest_setup() {

        System.out.println("Tests litecart Started");

        System.setProperty("webdriver.chrome.driver", driverPathChrome);
        drvChrome = new ChromeDriver();

        drvChrome.get("http://localhost/litecart/admin/?app=appearance&doc=template");

        drvChrome.findElement(By.name("username")).sendKeys("admin");
        drvChrome.findElement(By.name("password")).sendKeys("admin");
        drvChrome.findElement(By.name("login")).click();

        // WebDriver.ChromeDriver().setup();
        // drvChrome = new ChromeDriver();
    }

    @After
    public void litecartTest_cleanup() {
        drvChrome.quit();
        System.out.println("Tests litecart Finished");
    }

    @Test
    public void litecarPageAfertLoginTest() throws InterruptedException {

        System.out.println("Test litecartLogin Starteded");

        // if(isElementPresent(drvChrome, By.className("header"))) --> this if with By.className is correct to
        if (isElementPresent(drvChrome, By.id("body-wrapper")))
        {
            System.out.println("Element found");
        }
        else
            {
            System.out.println("Element not found");
        }

        Thread.sleep(3000);

        System.out.println("Test litecartLogin Finished");
    }


    @Test
    public void appearenceTemplatePpage() {

        if (isElementPresent(drvChrome, By.name("template_form")))
        {
            System.out.println("Element found");
        }
        else
            {
            System.out.println("Element not found");
        }
    }

    @Test
    public void appearenceLogotypePpage() {

        drvChrome.get("http://localhost/litecart/admin/?app=appearance&doc=logotype");

        //if(isElementPresent(drvChrome, By.className("fa-stack icon-wrapper"))) logotype_form
        if (isElementPresent(drvChrome, By.name("logotype_form")))
        {
            System.out.println("Element found");
        }
        else
            {
            System.out.println("Element not found");
        }
    }

    private boolean isElementPresent(WebDriver driver, By locator) {

        try {
            driver.findElement(locator);
            return true;
        }
        catch (InvalidSelectorException ex)
        {
            throw ex;
        }
        catch (NoSuchElementException ex) {
            return false;
        }
    }
}