package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;

public class Search {

    private SelenideElement searchInput = $(accessibilityId("Search Wikipedia")),

    searchSrc = $(id("org.wikipedia:id/search_src_text")),


    skipBtn = $(id("org.wikipedia:id/fragment_onboarding_skip_button")),

    textTitle = $(className("android.widget.TextView"));

    private ElementsCollection itemTitleList = $$(id("org.wikipedia:id/page_list_item_title"));

    @Step("Нажатине на кнопку Skip в привествующем меню")
    public Search clickSkipBtn() {

        skipBtn.click();
        return this;
    }
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

    @Step("Нажатие на первый элемент из списка поиска")
    public Search clickFirstSearchItem() {

        itemTitleList.first().click();
        return this;
    }

    @Step("Проверка наличия соотвествующего заголовка на странице")
    public Search checkTitle(String value) {

        textTitle.shouldHave(text(value));
        return this;
    }
}
