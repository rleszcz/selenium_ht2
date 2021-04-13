package testing;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAmazonTest extends MyBasicTest {

    static final String MUSIC_ITEM_ON_SIDE_MENU_XPATH = "//div[@id=\"hmenu-content\"]//*[contains(text(), \"Amazon Music\")]";
    static final String BOOKS_ITEM_ON_SIDE_MENU_XPATH = "//div[@id=\"hmenu-content\"]//*[contains(text(), \"Kindle E-readers & Books\")]";
    static final String APPS_ITEM_ON_SIDE_MENU_XPATH = "//div[@id=\"hmenu-content\"]//*[contains(text(), \"Appstore for Android\")]";

    static final String SEARCH_PHRASE = "Lego 42100";
    static final String ITEM_NAME = "LEGO Technic Liebherr R 9800 Excavator 42100 Building Kit (4,108 Pieces)";
    static final String ITEM_IN_BASKET_XPATH = "//div[@class=\"sc-list-item-content\"]";

    static final String SELECTED_COUNTRY = "Albania";
    static final String COUNTRY_XPATH = "//span[@class=\"nav-line-2 nav-progressive-content\"]";

    static final String SELECTED_CURRENCY = "€ - EUR - Euro";
    static final String BUYBOX_PRICE_XPATH = "//span[@id=\"price_inside_buybox\"]";
    static final String SELECTED_CURRENCY_SHORT = "EUR";

    @Test
    public void checkSideMenuItemsOfDigitalContentSectionTest() {
        homePage.open().openSideMenu();
        Assert.assertTrue(driver.findElement(By.xpath(MUSIC_ITEM_ON_SIDE_MENU_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(BOOKS_ITEM_ON_SIDE_MENU_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(APPS_ITEM_ON_SIDE_MENU_XPATH)).isDisplayed());
    }

    @Test
    public void findItemAndAddToBasketTest() {
        homePage.open()
                .searchFor(SEARCH_PHRASE);
        searchResultsPage.clickOnExpectedItem();
        selectedItemPage.clickOnAddToCartButton()
                .clickOnGoToCartButton();
        cartPage.waitForItemToAppear();
        Assert.assertTrue(driver.findElement(By.xpath(ITEM_IN_BASKET_XPATH)).getText().contains(ITEM_NAME));
    }

    @Test
    public void changeDeliveryDestinationToAlbaniaTest() {
        homePage.open()
                .changeDeliveryDestination(SELECTED_COUNTRY);
        Assert.assertTrue(driver.findElement(By.xpath(COUNTRY_XPATH)).getText().contains(SELECTED_COUNTRY));
    }

    @Test
    public void changeCurrencyToEuroTest() {
        homePage.open()
                .openLanguageAndCurrencySettings();
        languageAndCurrencySettingsPage.changeCurrency(SELECTED_CURRENCY);
        homePage.searchFor(SEARCH_PHRASE);
        searchResultsPage.clickOnExpectedItem();
        Assert.assertTrue(driver.findElement(By.xpath(BUYBOX_PRICE_XPATH)).getText().contains(SELECTED_CURRENCY_SHORT));
    }

}
