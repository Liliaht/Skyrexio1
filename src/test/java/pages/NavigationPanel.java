package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPanel {
    private WebDriver driver;

    private final By cartlink = By.cssSelector("[data-test = shopping-cart-link]");

    public NavigationPanel(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToCart() {
        driver.findElement(cartlink).click();
    }
}