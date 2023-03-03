import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AccountPage extends Setup{

    @Test(priority = 14)
    public void ClickCreateAccount(){
        getDriver().findElement(By.xpath("//a[@id='createAccountSubmit']")).click();
    }

    @Test(priority = 15)
    @Parameters({"sampleName","sampleEmail","samplePassword"})
    public void CreateAccount(String sampleName,String sampleEmail, String samplePassword){
        getDriver().findElement(By.id("ap_customer_name")).sendKeys(sampleName);
        getDriver().findElement(By.id("ap_email")).sendKeys(sampleEmail);
        getDriver().findElement(By.id("ap_password")).sendKeys(samplePassword);
        getDriver().findElement(By.id("ap_password_check")).sendKeys(samplePassword);
    }
}
