package EndToEnd.Loggi.Tests;

import EndToEnd.Google.PageObjects.HomePO;
import EndToEnd.Loggi.PageObjects.PackageStatusPO;
import EndToEnd.Loggi.PageObjects.TrackPackagePO;
import Utils.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Utils.Utils.elementClick;

public class Runner {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.loggi.com/");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();

    }

    @Test (testName = "Fluxo principal")
    public void teste01()  {
        HomePO homePO = new HomePO(driver);
        homePO.closePopUpBtn();
        homePO.validateHome();
        homePO.clickTrackPackageBtn();
        TrackPackagePO trackPackagePO = new TrackPackagePO(driver);
        trackPackagePO.validateTrackingPage();
        trackPackagePO.sendTrackingCode("AL213348903BR");
        trackPackagePO.clickTrackingOrder();
        PackageStatusPO packageStatusPO = new PackageStatusPO(driver);
        packageStatusPO.validateStatusPage();
        packageStatusPO.insertCPF("057.195.813-32");
        packageStatusPO.clickBlueBtn();
        packageStatusPO.validateDateAndReceiver();




    }
}
