package tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {
    List<String> goodsList =
            List.of("Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie", "Sauce Labs Fleece Jacket");

    @Test
    public void checkGoodsAdded() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.pageTitleDisplayed());
        assertEquals(productsPage.getGoodsQuantity(), 6);
        productsPage.addToCart();
        /*productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");*/

        for (String goods : goodsList) {
            productsPage.addToCart(goods);
        }

        assertEquals(productsPage.chekCounterValue(), "4");
        assertEquals(productsPage.chekCounterColor(), "rgba(226, 35, 26, 1)");
        productsPage.clickCartIcon();
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
    }
}