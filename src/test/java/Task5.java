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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
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

        //   Add New Product  / General
        //*********************************************************
        // Status to Enable
        drvChrome.findElement(By.cssSelector("[value='1']")).click();

        // returns the current time in milliseconds + substring
        System.out.print("Current Time in milliseconds = ");
        System.out.println(System.currentTimeMillis());

        long currentMillSec = System.currentTimeMillis();
        String itemName = "Item"+String.valueOf(currentMillSec).substring(7,13);
        //populate field Name
        WebElement inputName = drvChrome.findElement(By.cssSelector("[name*=name]"));
        inputName.sendKeys(itemName);

     //  Code
        WebElement codeValue = drvChrome.findElement(By.cssSelector("[name=code]"));
        codeValue.sendKeys(String.valueOf(currentMillSec));

     //  Product Groups  / Unisex
        WebElement genderType = drvChrome.findElement(By.cssSelector("[value='1-3']"));
        genderType.click();

     // Quantity
        WebElement quantityValue = drvChrome.findElement(By.cssSelector("[value='0.00']"));
        quantityValue.clear();
        quantityValue.sendKeys("9");
        System.out.println(quantityValue.getText());


     // Date Valid From
        WebElement dateValidFrom = drvChrome.findElement(By.cssSelector("[name=date_valid_from]"));
        dateValidFrom.sendKeys("03/21/2019");

     // Date Valid To
        WebElement dateValidTo = drvChrome.findElement(By.cssSelector("[name=date_valid_to]"));
        dateValidTo.sendKeys("04/02/2019");

     // populate upload file image
        WebElement uploadImage = drvChrome.findElement(By.cssSelector("[name*=new_images]"));
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("schip.png").getFile());
        uploadImage.sendKeys(file.getAbsolutePath());

        System.out.println(file.getAbsolutePath());
        // printed  D:\src\out\test\resources\book.png

     // Go to Information
        drvChrome.findElement(By.cssSelector("[href*=information]")).click();

    // Manufacturer Select
       Select selectManufacturer = new Select(drvChrome.findElement(By.name("manufacturer_id")));
       selectManufacturer.selectByIndex(1);

    //Keywords     name="keywords"
        WebElement keywords = drvChrome.findElement(By.cssSelector("[name=keywords]"));
        keywords.sendKeys("Key Inform");

    //   Short Description
        WebElement shortDescr = drvChrome.findElement(By.cssSelector("[name*=short_description]"));
        shortDescr.sendKeys("Short_description of item");


    //  Description             trumbowyg-editor
        WebElement descript = drvChrome.findElement(By.cssSelector(".trumbowyg-editor"));
        descript.sendKeys(" Main description of item.");

    //  Head Title   [en]
        WebElement  headTitle = drvChrome.findElement(By.cssSelector("[name*=head_title]"));
        headTitle.sendKeys(" It's head title.");

    //  Meta Description
        WebElement  meta = drvChrome.findElement(By.cssSelector("[name*=meta_description]"));
        meta.sendKeys(" Don't worry Be happy!");


        // Go to Price
        drvChrome.findElement(By.cssSelector("[href*=tab-prices]")).click();

    //  Purchase Price
        WebElement  purchasePrice = drvChrome.findElement(By.cssSelector("[name=purchase_price]"));
        purchasePrice.clear();
        purchasePrice.sendKeys("10.00");

     // Purchase Price Select
        Select selectPurchasePrice = new Select(drvChrome.findElement(By.name("purchase_price_currency_code")));
        selectPurchasePrice.selectByIndex(2);

     // gross_prices[USD]
        WebElement  grossPricesUSD = drvChrome.findElement(By.cssSelector("[name='gross_prices[USD]']"));
        grossPricesUSD.clear();
        grossPricesUSD.sendKeys("32.00");

    //gross_prices[EUR]
        WebElement  grossPricesEUR = drvChrome.findElement(By.cssSelector("[name='gross_prices[EUR]']"));
        grossPricesEUR.clear();
        grossPricesEUR.sendKeys("24.00");

     // Save Add New Product
     //************************************************************************
       //drvChrome.findElement(By.cssSelector("[name=save]")).click();
        drvChrome.findElement(By.cssSelector("[name=save]")).submit();
}


    }
