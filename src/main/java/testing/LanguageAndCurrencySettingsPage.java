package testing;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LanguageAndCurrencySettingsPage extends BasePage{

    @FindBy(xpath = "//select[@id=\"icp-sc-dropdown\"]")
    public static WebElement CURRENCY_DROPDOWN;

    @FindBy(xpath = "//input[@aria-labelledby=\"icp-btn-save-announce\"]")
    public static WebElement SAVE_CHANGES_BUTTON;

    public LanguageAndCurrencySettingsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Step("Change currency")
    public LanguageAndCurrencySettingsPage changeCurrency(String currency) {
        new Select(waitToBeClickable(CURRENCY_DROPDOWN, driver)).selectByVisibleText(currency);
        clickOnElement(SAVE_CHANGES_BUTTON);
        return this;
    }

}
