package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class MyBasicTest {

    protected WebDriver driver;
    protected HomePage homePage = null;
    protected SearchResultsPage searchResultsPage = null;
    protected SelectedItemPage selectedItemPage = null;
    protected LanguageAndCurrencySettingsPage languageAndCurrencySettingsPage = null;
    protected CartPage cartPage = null;

    @BeforeMethod
    public void preparation() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        selectedItemPage = new SelectedItemPage(driver);
        languageAndCurrencySettingsPage = new LanguageAndCurrencySettingsPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

}
