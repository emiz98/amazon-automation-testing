import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePage extends Setup{

    @BeforeTest
    public void BeforeTest(){
        System.out.println("Driver1"+driver);
    }

    @Test(priority = 1)
    public void VerifyPage(){
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.amazon.com/","Incorrect Page");
    }

    @Test(priority = 2)
    public void SelectFromDropdown() {
        Select dropdown = new Select(getDriver().findElement(By.id("searchDropdownBox")));
        dropdown.selectByValue("search-alias=computers-intl-ship");
    }

    @Test(priority = 3)
    public void InputSearchItem(){
        getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
    }

    @Test(priority = 4)
    public void ClickSearch(){
        try {
            Thread.sleep(1000);
            getDriver().findElement(By.id("nav-search-submit-button")).click();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
