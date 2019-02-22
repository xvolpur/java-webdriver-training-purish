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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CampaignsYellowDuck {

    private WebDriver drvChrome;
    private WebDriver drvFirefox;
    private WebDriver drvEdge;

    private WebDriverWait wait;
    private String driverPathFirefox = "d:/Projects/geckodriver-v0.24.0-win64/geckodriver.exe";
    private String driverPathEdge = "d:/Projects/MicrosoftWebDriver.exe";

    private String baseURL = "http://localhost/litecart/public_html/en/";

    @Before
    public void campaings_setup() {

        System.out.println("TestsYellow Duck Started");

        WebDriverManager.chromedriver().setup();
        drvChrome = new ChromeDriver();

        //System.setProperty("webdriver.gecko.driver", driverPathFirefox);
        //drvFirefox = new FirefoxDriver();

        //System.setProperty("webdriver.edge.driver",driverPathEdge);
        //drvEdge = new EdgeDriver();

        wait =new WebDriverWait(drvChrome, 12);
        //driver.manage().window().maximize();

       ///// By mainPage = By.id("box-campaings");

        drvChrome.navigate().to(baseURL);
       // drvFirefox.navigate().to(baseURL);
        ///// ---> drvEdge.navigate().to(baseURL);


        // if (isElementPresent(sidebar)) return;    #box-campaigns

      //  wait = new WebDriverWait(driver, 7);       //*[@id="box-campaigns"]

    }

    @After
    public void campaings__cleanup() {
       // driver.quit();
        System.out.println("Tests Yellow Duck Finished");
    }

    private boolean isElementPresent(By element) {
        return drvChrome.findElements(element).size() > 0;
    }

    @Test
    public void campaing() {

        //   itemPage

        //WebElement yduck =  drvChrome.findElement(By.className("Similar Products")).getText();
        if ( drvChrome.findElement(By.className("Similar Products")).getText() = ' ')
        drvChrome.findElement(By.cssSelector("a.title='Yellow Duck'")).click();
        else
            System.out.println("error load");



       wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("Categories")));
        //driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
      ///By.id ...).isDisplayed():
        // elem = driver.findElement(By.cssSelector(#rotate"); rotate - это id
        // elem.size();
        //elem.location();
        //  chrome, firefox, edge -  для всех



      // String attrib =drvChrome.findElement(By.className("image-wrapper")).getAttribute("offsetHeight");
       // WebElement as = driver.getAttribute("innerHTML");
       //String attrib = as.getAttribute("offsetHeight");
        System.out.println("offsetHeight = " + drvChrome.findElement(By.className("image-wrapper")).getAttribute("offsetHeight"));

    }



}