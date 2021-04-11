package testing;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {
    private static final String HOME_PAGE_URL = "https://www.amazon.com/";

    @FindBy(id = "twotabsearchtextbox")
    public static WebElement SEARCH_FIELD;

    @FindBy(id = "nav-hamburger-menu")
    public static WebElement SIDE_MENU_BUTTON;

    @FindBy(id = "nav-global-location-data-modal-action")
    public static WebElement DELIVER_TO_BUTTON;

    @FindBy(xpath = "//select[@class=\"a-native-dropdown\"]")
    public static WebElement COUNTRY_DROPDOWN;

    @FindBy(xpath = "//span[@class=\"a-declarative\"]")
    public static WebElement DONE_BUTTON;

    @FindBy(id = "icp-nav-flyout")
    public static WebElement LANGUAGE_BUTTON;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Step("Open home page")
    public HomePage open() {
        openWebPage(HOME_PAGE_URL);
        return this;
    }

    @Step("Open side menu")
    public HomePage openSideMenu() {
        clickOnElement(waitToBeVisible(SIDE_MENU_BUTTON, driver));
        return this;
    }

    @Step("Search for a product")
    public HomePage searchFor(String itemName) {
        enterTextIntoField(SEARCH_FIELD, itemName);
        pressKey(Keys.ENTER);
        return this;
    }

    @Step("Change delivery destination")
    public HomePage changeDeliveryDestination(String countryName) {
        clickOnElement(DELIVER_TO_BUTTON);
        new Select(waitToBeClickable(COUNTRY_DROPDOWN, driver)).selectByVisibleText(countryName);
        clickOnElement(DONE_BUTTON);
        return this;
    }

    @Step("Open language and currency settings page")
    public HomePage openLanguageAndCurrencySettings() {
        clickOnElement(LANGUAGE_BUTTON);
        return this;
    }

}
