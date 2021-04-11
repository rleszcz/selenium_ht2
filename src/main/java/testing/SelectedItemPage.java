package testing;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedItemPage extends BasePage {

    @FindBy(id = "add-to-cart-button")
    public static WebElement ADD_TO_CART_BUTTON;

    @FindBy(id = "attach-sidesheet-view-cart-button")
    public static WebElement GO_TO_CART_BUTTON;

    public SelectedItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Step("Click on add to cart button")
    public SelectedItemPage clickOnAddToCartButton() {
        clickOnElement(ADD_TO_CART_BUTTON);
        return this;
    }

    @Step("Click on go to cart button")
    public SelectedItemPage clickOnGoToCartButton() {
        clickOnElement(waitToBeClickable(GO_TO_CART_BUTTON, driver));
        return this;
    }
}
