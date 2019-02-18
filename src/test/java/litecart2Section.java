import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class litecart2Section {

    WebDriver drvChrome;
    private String driverPathChrome="D:/Projects/chromedriver.exe";

    @Before
    public void litecartTest_setup() {
        System.out.println("Tests Started");
        System.setProperty("webdriver.chrome.driver", driverPathChrome);
        drvChrome = new ChromeDriver();

      // WebDriver.ChromeDriver().setup();
       // drvChrome = new ChromeDriver();
    }

    @After
    public void litecartTest_cleanup(){
        //drv.quit();
        System.out.println("Tests Finished");
    }

    @Test
    public void litecartTest() throws InterruptedException {

        System.out.println("Test litecart Starteded");


        drvChrome.get("http://localhost/litecart/admin/?app=appearance&doc=template");

        drvChrome.findElement(By.name("username")).sendKeys("admin");
        drvChrome.findElement(By.name("password")).sendKeys("admin");
        drvChrome.findElement(By.name("login")).click();

        Thread.sleep(3000);
        drvChrome.quit();

        System.out.println("Test litecart Finished");
    }






}
