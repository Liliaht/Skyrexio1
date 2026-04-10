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
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
    }
    @Test
    public void checkIncorrectLogin() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails to apper");
        assertEquals(loginPage.errorMessageText(), "Epic sadface: Username and password do not match any user in this service");
    }
}