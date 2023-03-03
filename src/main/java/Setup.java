import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Setup {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static String productName;
    public static String productPrice;

    @Parameters({"browserType","webUrl"})
    @BeforeTest
    public static void CreateInstance(String browserType,String webUrl){
        System.out.println("Running "+browserType+" on thread "+Thread.currentThread().getId());
        if(browserType.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver2.exe");
            driver.set(new ChromeDriver());
        }else if(browserType.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
            driver.set(new FirefoxDriver());
        }else{
            Assert.fail("Please pass browser as parameter");
        }
        getDriver().manage().window().maximize();
        getDriver().get(webUrl);
        }

    @AfterTest
    public void AfterTest(){
        getDriver().close();
    }
}
