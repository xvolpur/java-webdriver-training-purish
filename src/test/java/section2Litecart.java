import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class section2Litecart {

    private WebDriver driver;
    private WebDriverWait wait;

    private String baseURL = "http://localhost/litecart";
    private String username = "admin";
    private String password = "admin";

    @Before
    public void litecartTest_setup() {

        System.out.println("Tests litecart Started");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 4);
        performLogin();

    }

    @After
    public void litecartTest_cleanup() {
        driver.quit();
        System.out.println("Tests litecart Finished");
    }

    private void performLogin(){
        By sidebar = By.id("sidebar");

        driver.navigate().to(baseURL + "/admin");

        if (isElementPresent(sidebar)) return;

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(sidebar));
    }

private boolean isElementPresent(By element) {
        return driver.findElements(element).size() > 0;
    }

    @Test
    public void litecartMenuPages() {

        By menuBlock = By.cssSelector("#sidebar ul#box-apps-menu");
        List<WebElement> menuItems = driver.findElement(menuBlock).findElements(By.xpath("./li"));

              //   IMPORTANT
/*  DOM is reconstructed after click(); we need read element and just use his after read !!!
         for (WebElement menuItem: menuItems)
         {
             System.out.println("item: "+menuItem.getText() );
             menuItem.click();
         }
*/
        By selectedItem = By.cssSelector("li.selected");

        int menuSize = driver.findElement(menuBlock).findElements(By.xpath("./li")).size();//returned size of collection

        for (int menuItem = 1; menuItem <= menuSize; menuItem++) {
            driver.findElement(menuBlock).findElement(By.xpath("./li[" + menuItem + "]")).click();
            Assert.assertTrue("Page Title (h1 element) not found", isElementPresent(By.cssSelector("h1")));

            int subMenuSize = driver.findElement(menuBlock).findElement(selectedItem).findElements(By.cssSelector("li")).size();
                                                                       // may be as   findElements(By.xpath("./li") with same result
            if (subMenuSize > 0) {      // we go through submenu items
                for (int subMenuItem = 1; subMenuItem <= subMenuSize; subMenuItem++) {
                    driver.findElement(selectedItem).findElement(By.cssSelector("li:nth-of-type(" + subMenuItem + ")")).click();
                    Assert.assertTrue("Page Title (h1 element) not found", isElementPresent(By.cssSelector("h1")));
                }
            }
        }
    }
}


