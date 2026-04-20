package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CART_PATTERN =
            "//div[text()='%s']" +
                    "//ancestor::div[@class='inventory_idem']" +
                    "//child::button[text[]='Add to cart']";

    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By cartBadge = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));
    private final By addToCartBtn = By.xpath("//*[text()='Add to cart']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void addToCart() {
        driver.findElements(addToCartBtn).get(0).click();
    }

    public int getGoodsQuantity() {
        return driver.findElements(addToCartBtn).size();
    }

    public void addToCart(final String goodsName) {
        By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, goodsName));

        driver.findElement(addToCartBtn).click();
    }

    public boolean pageTitleDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public String chekCounterValue() {
        return driver.findElement(cartBadge).getText();
    }

    public String chekCounterColor() {
        return driver.findElement(cartBadge).getCssValue("background-color");
    }
}

    /*public void switchToCart() {
        driver.findElement(cartLink).click();
    }


    public void clickCartIcon() {
        driver.findElement(By.className("shopping_cart_link")).click();
   }
   }
     */