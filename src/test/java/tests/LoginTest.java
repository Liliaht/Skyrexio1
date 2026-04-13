package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
    }

    @Test(dataProvider = "incorrctDate")
    public void checkIncorrectLogin(String user, String password, String errorMeesage) {
        loginPage.open();
        loginPage.login(user, password);
        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails to apper");
        assertEquals(loginPage.errorMessageText(), errorMeesage,
                "Error message doesen't correspond");
    }

    @DataProvider(name = "incorrctDate")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"Standard_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
/*    @Test
    public void checkEmptyUserLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails to apper");
        assertEquals(loginPage.errorMessageText(), "Epic sadface: Username is required",
                "Error message doesen't correspond");
    }

    @Test
    public void checkUpperCasedLogin() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails to apper");
        assertEquals(loginPage.errorMessageText(), "Epic sadface: Password is required",
                "Error message doesen't correspond");
    }

    @Test
    public void checkLockedUserLogin() {
        loginPage.open();
        loginPage.login("Standard_user", "secret_sauce");
        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails to apper");
        assertEquals(loginPage.errorMessageText(), "Epic sadface: Username and password do not match any user in this service",
                "Error message doesen't correspond");
    }

 */