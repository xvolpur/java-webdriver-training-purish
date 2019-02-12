import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
//import org.junit.Test;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleGoogleTest {

    WebDriver drv;

    @Before
    public void googleTest_setup(){

        WebDriverManager.chromedriver().setup();
        drv = new ChromeDriver();
        //System.out.println("Test Started");
    }

    @After
    public void googleTest_cleanup(){
        drv.quit();
    }

    @Test
    public void googleTest() {
        //WebDriver drv = new ChromeDriver();

        drv.get("https://google.com");
        drv.findElement(By.name("q")).sendKeys("Selenium");
        drv.findElement(By.name("btnK")).click();

        //drv.quit();
    }
    //@Test
    //public void googleTest1() {
    //
     //   Assert.assertTrue(true);
     //
    //}
    //@Test
    //public void googleTest2() {
     //
     //   Assert.assertTrue(false);
     //
    //}
}
