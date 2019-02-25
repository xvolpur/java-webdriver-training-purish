import org.junit.After;
import org.junit.Assert;
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

import static javafx.scene.paint.Color.rgb;

public class CampaignsYellowDuck {

    private WebDriver drvChrome;
    private WebDriver drvFirefox;
    private WebDriver drvEdge;

    private WebDriverWait wait;
    private String driverPathFirefox = "d:/Projects/geckodriver-v0.24.0-win64/geckodriver.exe";
    private String driverPathEdge = "d:/Projects/MicrosoftWebDriver.exe";

    private String baseURL = "http://localhost/litecart/en/";

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
     drvChrome.quit();
        System.out.println("Tests Yellow Duck Finished");
    }

    private boolean isElementPresent(By element) {
        return drvChrome.findElements(element).size() > 0;
    }

    @Test
    public void campaing() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#fancybox-title")));

                //                                       Main Page
        //***********************************************************************************************************
        WebElement mainCampaing = drvChrome.findElement(By.cssSelector("#box-campaigns"));

        String regPriceMainCampaing = mainCampaing.findElement(By.cssSelector(".regular-price")).getText();

        String discontPriceCampaing = mainCampaing.findElement(By.cssSelector(".campaign-price")).getText();

        String mainPageName = mainCampaing.findElement(By.cssSelector(".name")).getText();

      // c.	Regular price is gray and strike ( ) on Main page
      Assert.assertEquals( mainCampaing.findElement(By.cssSelector(".regular-price")).getCssValue("color"),"rgb(119, 119, 119)");
/*   Expected :rgba(119, 119, 119, 1)
     Actual   :rgb(119, 119, 119)     */

       Assert.assertEquals( mainCampaing.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration-line:"),"line-through");
/*    Expected :
      Actual   :line-through   */

        //   d.	Campaigns price is red and bold on Main page
      Assert.assertEquals(mainCampaing.findElement(By.cssSelector(".campaign-price")).getCssValue("color"),"rgb(204, 0, 0)" );
/*     Expected :rgba(204, 0, 0, 1)
       Actual   :rgb(204, 0, 0)    */

      Assert.assertEquals(mainCampaing.findElement(By.cssSelector(".campaign-price")).getCssValue("font-weight"), "700");
        /*    Expected =  Actual   */

         //                              ITEM
        //***************************************************************************************************
      mainCampaing.findElement(By.cssSelector(".name")).click();

      WebElement item =  drvChrome.findElement(By.cssSelector("div.information"));

        // a.	Product Name is equal on Main page and on Item Page
      Assert.assertEquals(drvChrome.findElement(By.cssSelector("h1.title")).getText(),mainPageName );

        // b.	Prices (discount and regular) are equal on both pages
      Assert.assertEquals(item.findElement(By.cssSelector(".regular-price")).getText(),regPriceMainCampaing );

      Assert.assertEquals(item.findElement(By.cssSelector(".campaign-price")).getText(),discontPriceCampaing );

//        c.	Regular price is gray and strike ( ) on ITEM page
      Assert.assertEquals(item.findElement(By.cssSelector(".regular-price")).getCssValue("color"),"rgb(102, 102, 102)");
/*    Expected :rgba(102, 102, 102, 1)
      Actual   :rgb(102, 102, 102)       */

      Assert.assertEquals(item.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration-line:"),"line-through");
/*    Expected :
      Actual   :line-through    */

      //    d.	Campaigns price is red and bold on both pages
      Assert.assertEquals(item.findElement(By.cssSelector(".campaign-price")).getCssValue("color"),"rgb(204, 0, 0)" );
/*    Expected :rgba(204, 0, 0, 1)
      Actual   :rgb(204, 0, 0)
 */
       Assert.assertEquals(item.findElement(By.cssSelector(".campaign-price")).getCssValue("font-weight"),"700" );
/*    Expected =  Actual   */

    }
}