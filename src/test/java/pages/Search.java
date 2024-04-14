package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class Search {

    private SelenideElement searchInput = $(accessibilityId("Search Wikipedia")),

    searchSrc = $(id("org.wikipedia.alpha:id/search_src_text"));

    private ElementsCollection itemTitleList = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Нажатие на поле поиска")
    public Search clickSearchInput() {

        searchInput.click();
        return this;
    }

    @Step("Ввод значения в поле поиска")
    public Search setSearchValue(String value) {
        searchSrc.sendKeys(value);

        return this;
    }

    @Step("Проверка что наличие поиска элементов больше 0")
    public Search checkSearchContent() {
        itemTitleList.shouldHave(sizeGreaterThan(0));

        return this;
    }
}
