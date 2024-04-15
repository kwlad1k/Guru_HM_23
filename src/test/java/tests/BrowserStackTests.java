package tests;

import config.DriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import pages.Search;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class BrowserStackTests extends TestBase {

    Search search = new Search();
    DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

    @Test
    void successfulSearchTest() {
        search.clickSkipBtn()
                .clickSearchInput()
                .setSearchValue(driverConfig.searchValue())
                .checkSearchContent();
    }

    @Test
    void openArticleTest() {
        search.clickSkipBtn()
                .clickSearchInput()
                .setSearchValue(driverConfig.searchValue())
                .checkSearchContent()
                .clickFirstSearchItem()
                .checkTitle(driverConfig.searchValue());
    }
}