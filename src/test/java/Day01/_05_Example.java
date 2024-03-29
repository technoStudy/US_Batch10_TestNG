package Day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _05_Example {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login" page
     * login
     * email:  testngusbatch@gmail.com
     * password: usbatch1234
     * verify that you see My Account
     **/

    @Test
    void loginTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement advanceButton = driver.findElement(By.id("details-button"));
        advanceButton.click();

        WebElement proceedLink = driver.findElement(By.id("proceed-link"));
        proceedLink.click();

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("testngusbatch@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("usbatch1234");

        WebElement loginButton = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        loginButton.click();

        WebElement myAccount = driver.findElement(By.xpath("(//div[@id=\"content\"]//h2)[1]"));

        Assert.assertTrue(myAccount.isDisplayed(), "Test is failed");

        driver.quit();
    }
}
