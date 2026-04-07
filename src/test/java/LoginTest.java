import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    WebDriver driver;

    @AfterMethod
    public void close() {
        driver.quit();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void checkLogin() {

        driver.findElement(By.cssSelector("[id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        String title = driver.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(title, "Products");
    }

    @Test
    public void checkIncorrectLogin() {

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("[id='user-name']")).sendKeys("locked_out_user");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        boolean isErrorMsgDisplayed = driver.findElement(By.xpath("//*[@data-test='error']")).isDisplayed();
        assertTrue(isErrorMsgDisplayed, "The error message fails to apper");
        String errorMessageText = driver.findElement(By.xpath("//*[@data-test='error']")).getText();
        assertEquals(errorMessageText, "Epic sadface: Username and password do not match any user in this service");
    }

}
