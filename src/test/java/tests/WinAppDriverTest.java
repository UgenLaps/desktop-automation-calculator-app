package tests;

import java.net.MalformedURLException;
import java.net.URL;
import org.testng.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;

public class WinAppDriverTest {

    private static WebElement CalculatorResult = null;
    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
         cap.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");

        WindowsDriver driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"),cap);
        CalculatorResult = driver.findElementByAccessibilityId("CalculatorResults");
        Assert.assertNotNull(CalculatorResult);
        
        Thread.sleep(1000);
        driver.findElementByName("One").click();
        Thread.sleep(300);
        driver.findElementByAccessibilityId("plusButton").click();
        Thread.sleep(300);
        driver.findElementByName("Two").click();
        Thread.sleep(300);
        driver.findElementByAccessibilityId("plusButton").click();
        Thread.sleep(300);
        driver.findElementByName("Six").click();
        Thread.sleep(300);
        driver.findElementByAccessibilityId("divideButton").click();
        Thread.sleep(300);
        driver.findElementByName("Three").click();
        Thread.sleep(300);
        driver.findElementByAccessibilityId("equalButton").click();

        String result = CalculatorResult.getText().replace("Display is", "").trim();

        Assert.assertEquals("3", result);

        Thread.sleep(5000);

        driver.quit();
    }
}
