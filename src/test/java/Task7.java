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

        EventFiringWebDriver eventDrv;
        private WebDriverWait wait;

        private String baseURL = "http://localhost/litecart";
        private String username = "admin";
        private String password = "admin";


        @Before
        public void setup() {

         // if we wii not see how to test running
         //ChromeOptions opt = new ChromeOptions();
         // opt.setHeadless(true);
         // eventDrv = new EventFiringWebDriver(new ChromeDriver(opt)); screenShort will be captured

            WebDriverManager.chromedriver().setup();
            eventDrv = new EventFiringWebDriver(new ChromeDriver());
            eventDrv.register(new Listener());

            wait = new WebDriverWait(eventDrv, 5);
            performLogin();
                   }

        @After
        public void stop() { eventDrv.quit();  }

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
            eventDrv.findElement(By.cssSelector("#screenShot")).click();

        }
/*
Task 7: Add logging capabilities to your test

1.Done 	Copy code from “Task 3 : Create scenario which navigates through all sections on Admin page” into new class (e.g. Task 7)
2.	Add EventFiringWebDriver
3.	Add logging before and after find element
4.	Add screenshot capture on exceptions
5.	Send me the link to your scenario on GitHub
6.	Optional: Execute scenario via RemoteWebDriver on local selenium server

 */
    }


