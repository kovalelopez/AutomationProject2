package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    public static WebElement getElement(WebDriver driver, By by) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }

    public static void elementClick(WebDriver driver, By by)  {
        WebElement element = getElement(driver, by);
        element.click();

    }

    public static void elementSendKeys(WebDriver driver, By by, String text)  {
        WebElement element = getElement(driver, by);
        element.click();
        element.sendKeys(text);
    }
}
