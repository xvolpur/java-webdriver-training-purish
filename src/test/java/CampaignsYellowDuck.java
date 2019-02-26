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

       // WebDriverManager.chromedriver().setup();
        //drvChrome = new ChromeDriver();

        //System.setProperty("webdriver.gecko.driver", driverPathFirefox);
        //drvFirefox = new FirefoxDriver();

        System.setProperty("webdriver.edge.driver",driverPathEdge);
        drvEdge = new EdgeDriver();

        //wait =new WebDriverWait(drvChrome, 12);
       // wait =new WebDriverWait(drvFirefox, 12);
        wait =new WebDriverWait(drvEdge, 12);
        //driver.manage().window().maximize();

        //drvChrome.navigate().to(baseURL);
       // campaing();
        //drvFirefox.navigate().to(baseURL);
        //campaing_fireFox();
       drvEdge.navigate().to(baseURL);

    }

    @After
    public void campaings__cleanup() {
      drvChrome.quit();
     //drvFirefox.quit();
     drvEdge.quit();
        System.out.println("Tests Yellow Duck Finished");
    }

    @Test
    public void campaing_Edge(){
        System.out.println("begin Edge proc ");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#fancybox-title")));
        System.out.println("Edge test is started ");
        //                                       Main Page
        //***********************************************************************************************************
        WebElement mainCampaing = drvEdge.findElement(By.cssSelector("#box-campaigns"));

        String regPriceMainCampaing = mainCampaing.findElement(By.cssSelector(".regular-price")).getText();

        String discontPriceCampaing = mainCampaing.findElement(By.cssSelector(".campaign-price")).getText();

        String mainPageName = mainCampaing.findElement(By.cssSelector(".name")).getText();

        System.out.println("Edge test point 3");

        // c.	Regular price is gray and strike ( ) on Main page
        Assert.assertEquals( mainCampaing.findElement(By.cssSelector(".regular-price")).getCssValue("color"),"rgb(119, 119, 119)");
        /*    Expected =  Actual   */

        // Assert.assertEquals( mainCampaing.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration-line:"),"line-through");   same with Chrome
/*    Expected :
      Actual   :line-through   */

        //   d.	Campaigns price is red and bold on Main page
        Assert.assertEquals(mainCampaing.findElement(By.cssSelector(".campaign-price")).getCssValue("color"),"rgb(204, 0, 0)" );
        /*    Expected =  Actual   */

        Assert.assertEquals(mainCampaing.findElement(By.cssSelector(".campaign-price")).getCssValue("font-weight"), "700");
        /*    Expected =  Actual   */
        System.out.println("Edge test point 4 - Item will be started");
        //                              ITEM
        //***************************************************************************************************
        mainCampaing.findElement(By.cssSelector(".name")).click();
        System.out.println("Edge test point 5 - Item is started");
        /////WebElement item =  drvEdge.findElement(By.id("add_cart_product"));
        System.out.println("Edge test point 6 ");
        // a.	Product Name is equal on Main page and on Item Page
        Assert.assertEquals(drvEdge.findElement(By.cssSelector("h1.title")).getText(),mainPageName );
        System.out.println("Edge test point 7 ");
        // b.	Prices (discount and regular) are equal on both pages
        Assert.assertEquals(drvEdge.findElement(By.cssSelector(".regular-price")).getText(),regPriceMainCampaing );
        System.out.println("Edge test point 8 ");
        Assert.assertEquals(drvEdge.findElement(By.cssSelector(".campaign-price")).getText(),discontPriceCampaing );
        System.out.println("Edge test point 9 ");
//        c.	Regular price is gray and strike ( ) on ITEM page
        Assert.assertEquals(drvEdge.findElement(By.cssSelector(".regular-price")).getCssValue("color"),"rgb(102, 102, 102)");
        /*    Expected =  Actual   */
        System.out.println("Edge test point 10 ");
        // Assert.assertEquals(item.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration-line:"),"line-through");
/*    Expected :
      Actual   :line-through    */

        //    d.	Campaigns price is red and bold on both pages
        Assert.assertEquals(drvEdge.findElement(By.cssSelector(".campaign-price")).getCssValue("color"),"rgb(204, 0, 0)" );
        /*    Expected =  Actual   */
        System.out.println("Edge test point 11 ");

        Assert.assertEquals(drvEdge.findElement(By.cssSelector(".campaign-price")).getCssValue("font-weight"),"700" );
        /*    Expected =  Actual   */
        System.out.println("Edge test is done ");
    }


    @Test
    public void campaing_fireFox(){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#fancybox-title")));
        System.out.println("Firefox test is started ");
        //                                       Main Page
        //***********************************************************************************************************
        WebElement mainCampaing = drvFirefox.findElement(By.cssSelector("#box-campaigns"));

        String regPriceMainCampaing = mainCampaing.findElement(By.cssSelector(".regular-price")).getText();

        String discontPriceCampaing = mainCampaing.findElement(By.cssSelector(".campaign-price")).getText();

        String mainPageName = mainCampaing.findElement(By.cssSelector(".name")).getText();

        // c.	Regular price is gray and strike ( ) on Main page
        Assert.assertEquals( mainCampaing.findElement(By.cssSelector(".regular-price")).getCssValue("color"),"rgb(119, 119, 119)");
        /*    Expected =  Actual   */

       // Assert.assertEquals( mainCampaing.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration-line:"),"line-through");   same with Chrome
/*    Expected :
      Actual   :line-through   */

        //   d.	Campaigns price is red and bold on Main page
        Assert.assertEquals(mainCampaing.findElement(By.cssSelector(".campaign-price")).getCssValue("color"),"rgb(204, 0, 0)" );
        /*    Expected =  Actual   */

        Assert.assertEquals(mainCampaing.findElement(By.cssSelector(".campaign-price")).getCssValue("font-weight"), "900");
        /*    Expected =  Actual   */

        //                              ITEM
        //***************************************************************************************************
        mainCampaing.findElement(By.cssSelector(".name")).click();

        WebElement item =  drvFirefox.findElement(By.cssSelector("div.information"));

        // a.	Product Name is equal on Main page and on Item Page
        Assert.assertEquals(drvFirefox.findElement(By.cssSelector("h1.title")).getText(),mainPageName );

        // b.	Prices (discount and regular) are equal on both pages
        Assert.assertEquals(item.findElement(By.cssSelector(".regular-price")).getText(),regPriceMainCampaing );

        Assert.assertEquals(item.findElement(By.cssSelector(".campaign-price")).getText(),discontPriceCampaing );

//        c.	Regular price is gray and strike ( ) on ITEM page
        Assert.assertEquals(item.findElement(By.cssSelector(".regular-price")).getCssValue("color"),"rgb(102, 102, 102)");
        /*    Expected =  Actual   */

        Assert.assertEquals(item.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration-line:"),"line-through");
/*    Expected :
      Actual   :line-through    */

        //    d.	Campaigns price is red and bold on both pages
        Assert.assertEquals(item.findElement(By.cssSelector(".campaign-price")).getCssValue("color"),"rgb(204, 0, 0)" );
         /*    Expected =  Actual   */


        Assert.assertEquals(item.findElement(By.cssSelector(".campaign-price")).getCssValue("font-weight"),"700" );
        /*    Expected =  Actual   */
        System.out.println("Firefox test is done ");
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