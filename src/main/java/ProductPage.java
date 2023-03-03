import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductPage extends Setup{

    @Test(priority = 7)
    public void ProductDetails(){
        WebElement productTitle = getDriver().findElement(By.id("productTitle"));
        System.out.println("Product Title : "+productTitle.getText());
        System.out.println("Product Title Length : "+productTitle.getText().length());
        productName=productTitle.getText();
    }

    @Test(priority = 8)
    public void ProductPrice(){
        List<WebElement> productPrices = getDriver().findElements(By.xpath("//div[@id='corePrice_feature_div']/div/span/span"));
        productPrice=productPrices.get(1).getText();
        System.out.println("Product Price : "+ productPrices.get(1).getText());
    }

    @Test(priority = 9)
    public void AddToCart(){
        try {
            Thread.sleep(2000);
            getDriver().findElement(By.id("add-to-cart-button")).submit();
        }catch (InterruptedException e){
            e.printStackTrace();

        }
    }

    @Test(priority = 10)
    public void ViewCart(){
        getDriver().manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        try {
            getDriver().findElement(By.id("nav-cart")).click();
        } catch (ElementClickInterceptedException e) {
            getDriver().findElement(By.xpath("//span[@id='attach-sidesheet-view-cart-button']/span/input")).click();
        }
    }

}
