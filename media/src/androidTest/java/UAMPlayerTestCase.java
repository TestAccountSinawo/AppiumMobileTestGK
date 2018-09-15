import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;


public class UAMPlayerTestCase {

    DesiredCapabilities cap = new DesiredCapabilities();
    AndroidDriver driver;

    @Test
    public void innitConfig() {
        cap.setCapability("deviceName", "9886784b45444f5741");
        cap.setCapability("deviceName", "Android");
        cap.setCapability(CapabilityType.BROWSER_NAME, "Android");
        cap.setCapability(CapabilityType.VERSION, "8.0");

        cap.setCapability("appPackage", "com.example.android.uamp.next");
        cap.setCapability("appActivity", "com.example.android.uamp.MainActivity");
    }
    @Test
    public void mainUAMPScreenTestCase() throws MalformedURLException {

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        driver.findElement(By.className("android.widget.ImageButton")).click();

        driver.findElement(By.className("com.example.android.uamp:id/design_menu_item_text")).click();
        driver.findElement(By.id("com.example.android.uamp:id/description")).click();

        driver.findElement(By.className("android.widget.RelativeLayout")).click();
        driver.findElement(By.className("android.widget.ImageButton")).click();

        String actualText = driver.findElement(By.id("com.example.android.uamp:id/title")).getText();
        Assert.assertEquals("Jazz & Blues",actualText);

        driver.findElement(By.className("android.widget.ImageButton")).click();
        String confirmGenrePage = driver.findElement(By.id("com.example.android.uamp:id/title")).getText();
        Assert.assertEquals("Genres",confirmGenrePage);
    }
}
