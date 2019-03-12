import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.By.cssSelector;

public class Task5Cart {

    private WebDriver drvChrome;
    private WebDriverWait wait;
    private String baseURL = "http://localhost/litecart/";

    @Before
    public void task5Cart_setup() {

        WebDriverManager.chromedriver().setup();
        drvChrome = new ChromeDriver();

        wait = new WebDriverWait(drvChrome, 5);
        drvChrome.manage().window().maximize();
        performLogin();
    }

    @After
    public void taskt5Cart_cleanup() {
        drvChrome.quit();
    }

    private void performLogin() {
        drvChrome.navigate().to(baseURL);
    }

    @Test
    public void task5_cart() {

            By listMenu = cssSelector("#box-most-popular > div > ul");
            int menuSize = drvChrome.findElement(listMenu).findElements(By.xpath("./li")).size();

            for (int menuItem = 1; menuItem <= menuSize; menuItem++) {

                WebElement currentMenuItemName = drvChrome.findElement(listMenu).findElement(By.xpath("./li[" + menuItem + "]"));
                WebElement tst5 = currentMenuItemName.findElement(By.cssSelector("a.link > div.name"));

                if ("Item".equals(tst5.getText().substring(0, 4))) {
                    tst5.click();
                    break;
                }
            }
            // add to cart
                    String cart0 = drvChrome.findElement(By.cssSelector(".quantity")).getText();
                    String[] value123 = {"1", "2", "3"};

                    for (int addIToCart = 0; addIToCart <= 2; addIToCart++) {
                        drvChrome.findElement(By.cssSelector("[name=add_cart_product]")).click();
                        wait.until((ExpectedConditions.textToBePresentInElement(drvChrome.findElement(By.cssSelector(".quantity")), value123[addIToCart])));
                    }

                    String cartQuantity = drvChrome.findElement(By.cssSelector(".quantity")).getText();

                    drvChrome.findElement(By.cssSelector("[id=cart]")).click();

             // remove items from cart
                        drvChrome.findElement(By.cssSelector("[name=remove_cart_item]")).click();

                     By removeItem = By.tagName("em");
                     wait.until(ExpectedConditions.presenceOfElementLocated(removeItem));

             drvChrome.get(baseURL);
    }
}
