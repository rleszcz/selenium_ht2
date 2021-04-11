package testing;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BasePage{

    static final String ITEM_NAME = "LEGO Technic Liebherr R 9800 Excavator 42100 Building Kit (4,108 Pieces)";

    @FindBy(linkText = ITEM_NAME)
    public static WebElement EXPECTED_ITEM;

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Step("Click on expected item")
    public SearchResultsPage clickOnExpectedItem(){
        clickOnElement(EXPECTED_ITEM);
        return this;
    }

}
