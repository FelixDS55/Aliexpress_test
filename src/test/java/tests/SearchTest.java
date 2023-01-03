package tests;

import com.codeborne.selenide.CollectionCondition;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static tests.TestBase.BASE_URL;

public class SearchTest{

    @Test
    void searchTest (){
        MainPage mainPage = new MainPage(BASE_URL);
        step("Проверка поиска товара", () -> {
            $("#searchInput").setValue("Pixel 7").pressEnter();
            $$(".snow-container_SnowContainer__container__hu0uqp").filterBy(text("Pixel 7"))
                    .shouldHave(CollectionCondition.sizeLessThanOrEqual(1));
        });
    }
}
