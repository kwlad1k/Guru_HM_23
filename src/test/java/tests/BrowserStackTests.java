package tests;

import config.DriverConfig;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Search;

public class BrowserStackTests extends TestBase {

    Search search = new Search();
    DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

    @Owner("Kwlad1ck")
    @DisplayName("Проверка выдачи статей после поискового запроса")
    @Test
    void successfulSearchTest() {
        search.clickSkipBtn()
                .clickSearchInput()
                .setSearchValue(driverConfig.searchValue())
                .checkSearchContent();
    }

    @Owner("Kwlad1ck")
    @DisplayName("Проверка открытия статьи и соответствия заголовка")
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