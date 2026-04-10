package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    WebDriver driver;
    private final By pageTitle = By.cssSelector("[data-test='title']");
    private final By addToCartBtn = By.xpath("//*[text()='Add to cart']");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }
}