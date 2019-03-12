import org.junit.After;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Task6 {

// window handles test
    private WebDriver driver;
    private WebDriverWait wait;

    private String username = "admin";
    private String password = "admin";

    private String baseURL = "http://localhost/litecart/admin/";
    private String driverPathFirefox = "d:/Projects/geckodriver-v0.24.0-win64/geckodriver.exe";

    @Before
    public void task_setup() {

        System.setProperty("webdriver.gecko.driver", driverPathFirefox);
        driver = new FirefoxDriver();

        wait = new WebDriverWait(driver, 10);

        performLogin();
    }

    @After
    public void task_cleanup() {   driver.quit();   }


    private void performLogin() {

       By sidebar = By.id("sidebar");
        if (isElementPresent(sidebar)) return;
        driver.navigate().to(baseURL);
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
       wait.until(ExpectedConditions.presenceOfElementLocated(sidebar));

     }

    private void newWindows(String firstWindow, Set<String> originalW) {
        Set<String> existWs = driver.getWindowHandles();
        String newW = wait.until(anyWindowOtherThan(originalW));
        driver.switchTo().window(newW);
        driver.close();
        driver.switchTo().window(firstWindow);
    }

    private boolean isElementPresent(By element) {
        return driver.findElements(element).size() > 0;
    }

    public ExpectedCondition<String> anyWindowOtherThan(Set<String> windows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver input) {
                Set<String> handles = driver.getWindowHandles();
                  handles.removeAll(windows);
                 return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }

    @Test
    public <WebPageTimeoutException> void task6_windows() {

      By menuBlock = By.cssSelector("#sidebar ul#box-apps-menu");
        List<WebElement> menuItems = driver.findElement(menuBlock).findElements(By.xpath("./li"));
        int menuSize = driver.findElement(menuBlock).findElements(By.xpath("./li")).size();
        for (int menuItem = 1; menuItem <= menuSize; menuItem++) {
            WebElement currentMenuItemName = driver.findElement(menuBlock).findElement(By.xpath("./li[" + menuItem + "]"));
            if ("Countries".equals(currentMenuItemName.getText().trim())) {
                currentMenuItemName.click();
                break;
            }
        }

        String firstWindow = driver.getWindowHandle();
        Set<String> originalW = driver.getWindowHandles();

        // chose countries
        By menuCountries = By.cssSelector("#content > form > table > tbody > tr:nth-child(2) > td:nth-child(7) > a > i");
        driver.findElement(menuCountries).click();

        ArrayList<String> cklicable = new ArrayList<String>();
        cklicable.add("#content > form > table:nth-child(2) > tbody > tr:nth-child(2) > td > a > i");
        cklicable.add("#content > form > table:nth-child(2) > tbody > tr:nth-child(3) > td > a > i");
        cklicable.add("#content > form > table:nth-child(2) > tbody > tr:nth-child(6) > td > a");
        cklicable.add("#content > form > table:nth-child(2) > tbody > tr:nth-child(7) > td > a:nth-child(3) > i");
        cklicable.add("#content > form > table:nth-child(2) > tbody > tr:nth-child(8) > td > a > i");
        cklicable.add("#content > form > table:nth-child(2) > tbody > tr:nth-child(9) > td > a > i");
        cklicable.add("#content > form > table:nth-child(2) > tbody > tr:nth-child(10) > td > a > i");

        for (int i = 0; i < cklicable.size(); i++){

            driver.findElement(By.cssSelector(cklicable.get(i))).click();
            newWindows(firstWindow, originalW);
        }

        System.out.println(" cickle is done ================");


    }
}
