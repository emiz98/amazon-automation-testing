import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CartPage extends Setup{

    @Test(priority = 11)
    public void verifyDetails(){
        SoftAssert softassert = new SoftAssert();
        List<WebElement> list = getDriver().findElements(By.xpath("//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-mini sc-info-block']/li"));
        WebElement price = getDriver().findElement(By.xpath("//p[@class='a-spacing-mini']"));
        softassert.assertEquals(list.get(0).getText(),productName,"Product Title Mismatch");
        Assert.assertEquals(price.getText(),productPrice,"Product Price Mismatch");
    }

    @Test(priority = 12)
    public void VerifySubTotal(){
        WebElement subtotal1 = getDriver().findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']/span"));
        WebElement subtotal2 = getDriver().findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']/span"));
        Assert.assertEquals(subtotal1.getText(),subtotal2.getText(),"Subtotals Not Matching");
    }

    @Test(priority = 13)
    public void Proceed(){
        try {
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//input[@value='Proceed to checkout']")).submit();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
