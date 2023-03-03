import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SearchPage extends Setup{

    @Test(priority = 5)
    public void SelectFeaturedBrands(){
        try {
            Thread.sleep(2000);
            List<WebElement> featuredBrands = getDriver().findElements(By.xpath("//div[@id='brandsRefinements']/ul/li"));
            featuredBrands.get(0).findElement(By.tagName("i")).click();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test(priority = 6)
    public void SelectFirstProduct(){
        WebElement firstProduct = getDriver().findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-index='1']"));
        firstProduct.findElement(By.xpath("//h2/a")).click();
    }
}
