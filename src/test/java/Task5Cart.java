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

public class Task5Cart {

    private WebDriver drvChrome;
    private WebDriverWait wait;
    private String baseURL = "http://localhost/litecart/";

    @Before
    public void task5Cart_setup() {

        System.out.println("Task5 is Started");

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
        System.out.println("Tests5cart is Finished");
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
    public <WebPageTimeoutException> void task5_cart() {

        for (int addItem = 1; addItem <= 3; addItem++) {
            By listMenu = cssSelector("#box-most-popular > div > ul");
            int menuSize = drvChrome.findElement(listMenu).findElements(By.xpath("./li")).size();
            System.out.println("menuSize=" + menuSize);
            List<WebElement> tst3 = drvChrome.findElement(listMenu).findElements(By.xpath("./li"));

            for (int menuItem = 1; menuItem <= menuSize; menuItem++) {

                WebElement currentMenuItemName = drvChrome.findElement(listMenu).findElement(By.xpath("./li[" + menuItem + "]"));
                WebElement tst5 = currentMenuItemName.findElement(By.cssSelector("a.link > div.name"));
                System.out.println("tst5 = " + tst5.getText() + "   0.4  = " + tst5.getText().substring(0, 4));

                 String currentInem = tst5.getText().substring(0, 4);
                 if ("Item".equals(currentInem)) {
                    tst5.click();
                                       System.out.println(" ------------ item----------click---------");
                    // add to cart
                                        //String cart0 =  drvChrome.findElement(By.className(".quantity")).getText();
                    //System.out.println(" before-----click---cart =   " +   cart0);
                     System.out.println(" item add----click--to -cart =   " );
                    drvChrome.findElement(By.cssSelector("[name=add_cart_product]")).click();

                    System.out.println(" after---add--click---cart   " );
                    // wait.until((ExpectedConditions.stalenessOf(By.className(".quantity")));
                   //
                  // String cart1 = drvChrome.findElement(By.className(".quantity")).getText() ;
                     System.out.println(" go to page ---cart   " );
                   //  drvChrome.findElement(By.cssSelector("#cart")).click() ;
                    //wait.until(numberOfElementsToBe(Integer.parseInt(cart0)),addItem);
                     System.out.println(" before---wait");
                     //WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2.title")));
                    // WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name=remove_cart_item]")));
                     System.out.println(" after---wait");
                   // String cartQuantity = drvChrome.findElement(By.cssSelector("snap#quantity")).getText();
                    //System.out.println("we are get cartQuantity " + cartQuantity);


                    //WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name=remove_cart_item]")));
                    // System.out.println(" checkout found");                     //String cart1 = drvChrome.findElement(By.cssSelector("[name=quantity > value]")).getText();

                     //String cart1 =    #cart > a.link
                       // System.out.println(" quantity---added to----cart =   " +   cart1);
                }

            }

 //drvChrome.Manage().Timeouts().PageLoadTimeout(TimeSpan.FromSeconds(40));
  // Use the timeout when navigating to a webpage
//            pageLoadTimeout
  try {

      drvChrome.navigate().to(baseURL);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title=Login]")));

  } catch (NoSuchElementException e) {
      System.out.println("Page: did not load within 40 seconds!");
      // treat the timeout as needed
  }


          //  drvChrome.navigate().to(baseURL);
           // System.out.println(" go to main page");
        }
    }

   //                       driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
}
