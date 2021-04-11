package testing;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"sc-list-item-content\"]")
    public static WebElement ITEM_IN_CART;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Step("Wait for item to appear")
    public CartPage waitForItemToAppear(){
        waitToBeVisible(ITEM_IN_CART, driver);
        return this;
    }

}
