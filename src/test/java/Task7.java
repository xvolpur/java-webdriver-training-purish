import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


    public class Task7 {

// screenshot capture on exceptions
        EventFiringWebDriver eventDrv;
        private WebDriverWait wait;

        private String baseURL = "http://localhost/litecart";
        private String username = "admin";
        private String password = "admin";


        @Before
        public void setup() {

/*       // if we will not see how to test running (screenShort will be captured) :
         ChromeOptions opt = new ChromeOptions();
         opt.setHeadless(true);
         eventDrv = new EventFiringWebDriver(new ChromeDriver(opt));
*/
            WebDriverManager.chromedriver().setup();
            eventDrv = new EventFiringWebDriver(new ChromeDriver());
            eventDrv.register(new Listener());

            wait = new WebDriverWait(eventDrv, 5);
            performLogin();
         }

        @After
        public void stop()
        {
            eventDrv.quit();
        }

        private void performLogin(){
            By sidebar = By.id("sidebar");

            eventDrv.navigate().to(baseURL + "/admin");

            if (isElementPresent(sidebar)) return;

            eventDrv.findElement(By.name("username")).sendKeys(username);
            eventDrv.findElement(By.name("password")).sendKeys(password);
            eventDrv.findElement(By.name("login")).click();

            wait.until(ExpectedConditions.presenceOfElementLocated(sidebar));
        }

        private boolean isElementPresent(By element) {
            return eventDrv.findElements(element).size() > 0;
        }

        public static class EventsListener extends AbstractWebDriverEventListener {}

        @Test
        public void menuPagesListener() {

            eventDrv.findElement(By.cssSelector("#platform"));
            eventDrv.findElement(By.cssSelector("#screenShot")).click();  // wrong

        }

    }


