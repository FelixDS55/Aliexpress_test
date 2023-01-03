package tests;

import com.codeborne.selenide.Condition;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SearchTest extends TestBase {

    @Test
    void searchTest (){
        MainPage mainPage = new MainPage(BASE_URL);
        step("Проверка поиска товара", () -> {
            $("#searchInput").setValue("Pixel 7").pressEnter();
            $(".snow-container_SnowContainer__container__hu0uqp").shouldHave(text("Pixel 7"));
        });
    }

}
