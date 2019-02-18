import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class SimpleGoogleTest<pathToOpera> {

    private WebDriver drvChromeManager;
    private WebDriver drvChrome;
    private WebDriver drvFirefox;
    private WebDriver drvEdge;
    private WebDriver drvOpera;

    private String driverPathChrome="D:/Projects/chromedriver.exe";
    private String driverPathFirefox = "d:/Projects/geckodriver-v0.24.0-win64/geckodriver.exe";
    private String driverPathEdge = "d:/Projects/MicrosoftWebDriver.exe";
    private String driverPathOpera = "d:/Projects/operadriver_win64/operadriver.exe";

    private String pathToOpera = "C:\\Users\\volodymyr.purish\\AppData\\Local\\Programs\\Opera\\58.0.3135.65_0\\opera.exe";

    @Before
    public void googleTest_setup(){
              System.out.println("Tests Started");
               }

    @After
    public void googleTest_cleanup(){
                 //drv.quit();
              System.out.println("Tests Finished");
               }
     @Test
     public void googleTest_ChromeManager() throws InterruptedException {

              System.out.println("Test ChromeManager Starteded");

                 WebDriverManager.chromedriver().setup();
                 drvChromeManager = new ChromeDriver();

                 drvChromeManager.get("https://google.com");
                 drvChromeManager.findElement(By.name("q")).sendKeys("Selenium");

                 Thread.sleep(3000);
                 drvChromeManager.quit();

              System.out.println("Test ChromeManager Finished");
               }

     @Test
     public void googleTest_ChromeLocalDrive() {

              System.out.println("Test Chrome Starteded");

                 System.setProperty("webdriver.chrome.driver", driverPathChrome);
                 drvChrome = new ChromeDriver();

                 drvChrome.get("https://google.com");
                 drvChrome.findElement(By.name("q")).sendKeys("Selenium");
                 drvChrome.quit();

              System.out.println("Test Chrome Finished");
               }

     @Test
     public void googleTest_Firefox() {

              System.out.println("Test Firefox Starteded");

                 System.setProperty("webdriver.gecko.driver", driverPathFirefox);
                 DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                 capabilities.setCapability("marionette", true);
                 drvFirefox = new FirefoxDriver(capabilities);

                 drvFirefox.get("https://google.com");
                 drvFirefox.findElement(By.name("q")).sendKeys("Selenium");
                 drvFirefox.quit();

              System.out.println("Test Firefox Finished");
               }

     @Test
     public void googleTest_Edge() {

              System.out.println("Test Edge Starteded");

                 System.setProperty("webdriver.edge.driver",driverPathEdge);
                 drvEdge = new EdgeDriver();

                 drvEdge.get("https://google.com");
                 drvEdge.findElement(By.name("q")).sendKeys("Selenium");
                 drvEdge.quit();

              System.out.println("Test Edge Finished");
               }


     @Test
     public void googleTest_Opera() {

              System.out.println("Test Opera Starteded");

                 DesiredCapabilities capabilities = new DesiredCapabilities();
                 OperaOptions options = new OperaOptions();
                 options.setBinary(pathToOpera);
                 capabilities.setCapability(OperaOptions.CAPABILITY, options);

                 System.setProperty("webdriver.opera.driver", driverPathOpera);
                 drvOpera = new OperaDriver(capabilities);

                 drvOpera.get("https://google.com");
                 drvOpera.findElement(By.name("q")).sendKeys("Selenium");
                 drvOpera.quit();

              System.out.println("Test Opera Finished");
               }



/*      There are old tests as example
    @Test
    public void googleTest() {
        WebDriver drv = new ChromeDriver();
        drv.get("https://google.com");
        drv.findElement(By.name("q")).sendKeys("Selenium");
        drv.findElement(By.name("btnK")).click();
        drv.quit();
    }
    @Test
    public void googleTest1() {
       Assert.assertTrue(true);
       }
      @Test
      public void googleTest2() {
        Assert.assertTrue(false);
        }
*/
}
