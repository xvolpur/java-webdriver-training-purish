import org.junit.After;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static javafx.scene.paint.Color.rgb;

public class Task5 {


    private WebDriver drvChrome;
    private WebDriverWait wait;
    private String baseURL = "http://localhost/litecart/admin";

    private String username = "admin";
    private String password = "admin";

    @Before
    public void task5_setup() {

        System.out.println("Task5 is Started");

        WebDriverManager.chromedriver().setup();
        drvChrome = new ChromeDriver();

        wait =new WebDriverWait(drvChrome, 18);
       //driver.manage().window().maximize();
         performLogin();
    }

    @After
    public void taskt5_cleanup() {
        // drvChrome.quit();
                System.out.println("Tests5 is Finished");
    }

    private void performLogin(){
        By sidebar = By.id("sidebar");

        drvChrome.navigate().to(baseURL);

      if (isElementPresent(sidebar)) return;

        drvChrome.findElement(By.name("username")).sendKeys(username);
        drvChrome.findElement(By.name("password")).sendKeys(password);
        drvChrome.findElement(By.name("login")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(sidebar));
    }

    private boolean isElementPresent(By element) {
        return drvChrome.findElements(element).size() > 0;
    }


    @Test
    public void task5_file(){

        By menuBlock = By.cssSelector("#sidebar ul#box-apps-menu");
        List<WebElement> menuItems = drvChrome.findElement(menuBlock).findElements(By.xpath("./li"));

        int menuSize = drvChrome.findElement(menuBlock).findElements(By.xpath("./li")).size();

        for (int menuItem = 1; menuItem <= menuSize; menuItem++) {

            WebElement currentMenuItemName = drvChrome.findElement(menuBlock).findElement(By.xpath("./li[" + menuItem + "]"));

            if ("Catalog".equals(currentMenuItemName.getText().trim())){  currentMenuItemName.click(); break; }
        }

          drvChrome.findElement(By.partialLinkText("Add New Product")).click();

        //   Add New Product General
        //*********************************************************

        // returns the current time in milliseconds + substring
        System.out.print("Current Time in milliseconds = ");
        System.out.println(System.currentTimeMillis());

        long currentMillSec = System.currentTimeMillis();
        String itemName = "Item"+String.valueOf(currentMillSec).substring(7,13);
        //populate field Name
        WebElement inputName = drvChrome.findElement(By.cssSelector("[name*=name]"));
        inputName.sendKeys(itemName);

     //  Product Groups  / Unisex
        WebElement genderType = drvChrome.findElement(By.cssSelector("[value='1-3']"));
        genderType.click();

     // populate upload file image
        WebElement uploadImage = drvChrome.findElement(By.cssSelector("[name*=new_images]"));
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("book.png").getFile());
        uploadImage.sendKeys(file.getAbsolutePath());

        System.out.println(file.getAbsolutePath());
        // printed  D:\src\out\test\resources\book.png


    }
}
