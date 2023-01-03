package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SearchTest extends TestBase {

    @Test
    void searchTest (){
        MainPage mainPage = new MainPage(BASE_URL);
        step("Проверка поиска товара", () -> {

        });
    }

}
