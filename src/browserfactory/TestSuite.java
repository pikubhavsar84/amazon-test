package browserfactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = " https://www.amazon.co.uk/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void testAmazonSearch () throws  InterruptedException {


       driver.findElement(By.id("sp-cc-accept")).click();

       sendTextToElement(By.id("twotabsearchtextbox"),"Dell Laptop");
       clickOnElement(By.id("nav-search-submit-button"));
      // clickOnElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']));



                // Search for "Dell Laptop"
        // Dell laptop
//        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
//        searchBox.sendKeys("Dell Laptop");
//        searchBox.submit();


         //Click on the checkbox brand Dell
        WebElement dellCheckbox = driver.findElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));
        dellCheckbox.click();

        // 4. Verify that the 30(May be different) products are displayed on the page
        //WebDriverWait wait = new WebDriverWait(10, TimeUnit);
        //WebDriverWait w = new WebDriverWait();
        List<WebElement> productElements = driver.findElements(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]"));
        System.out.println("Number of products displayed: " + productElements.size()); // May be different than 30

        // 5. Print all product names in the console
        for (WebElement productElement : productElements) {
            WebElement productNameElement = productElement.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]"));
            String productName = productNameElement.getText();
            System.out.println("Product name: " + productName);
        }

        // 6. Click on the product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...'
        WebElement dellXPSProductElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[20]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
        dellXPSProductElement.click();

        // 7. Verify the product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver'
        WebElement selectedProductNameElement = driver.findElement(By.xpath("//span[@id='productTitle']"));
        String selectedProductName = selectedProductNameElement.getText();
        System.out.println("Selected product name: " + selectedProductName);


    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}





