package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {
    @Test
    public void checkAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
}
