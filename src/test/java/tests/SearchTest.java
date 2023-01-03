package tests;

import com.codeborne.selenide.CollectionCondition;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchTest{

    @Test
    void searchTest (){
        step("Открываем сайт", () -> {
            open("https://aliexpress.ru/");
        });
        step("Проверка поиска товара", () -> {
            $("#searchInput").setValue("Pixel 7").pressEnter();
            $$(".snow-container_SnowContainer__container__hu0uqp").filterBy(text("Pixel 7"))
                    .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(1));
        });
    }
}
