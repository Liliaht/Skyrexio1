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

    @Test(dataProvider = "incorrectData")
    public void checkIncorrectLogin(String user, String password, String errorMeesage) {
        loginPage.open();
        loginPage.login(user, password);
        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails to appear");
        assertEquals(loginPage.errorMessageText(), errorMeesage,
                "Error message doesn't correspond");
    }

    @DataProvider(name = "incorrectData")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sad face: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sad face: Username is required"},
                {"standard_user", "", "Epic sad face: Password is required"},
                {"Standard_user", "secret_sauce", "Epic sad face: Username and password do not match any user in this service"}
        };
    }
}