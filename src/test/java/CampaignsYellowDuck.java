import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CampaignsYellowDuck {

    private WebDriver driver;
    private WebDriverWait wait;

    private String baseURL = "http://localhost/litecart/public_html/";

    @Before
    public void campaings_setup() {

        System.out.println("TestsYellow Duck Started");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait =new WebDriverWait(driver, 12);
        //driver.manage().window().maximize();

        By mainPage = By.id("box-campaings");

        driver.navigate().to(baseURL);



        // if (isElementPresent(sidebar)) return;    #box-campaigns

      //  wait = new WebDriverWait(driver, 7);       //*[@id="box-campaigns"]

    }

    @After
    public void campaings__cleanup() {
        driver.quit();
        System.out.println("Tests Yellow Duck Finished");
    }

    private boolean isElementPresent(By element) {
        return driver.findElements(element).size() > 0;
    }

    @Test
    public void campaing() {
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.name("#box-campaings")));
        //driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
    int asd;
      asd = 10;

    }



}