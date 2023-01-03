package tests;

import com.codeborne.selenide.Condition;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CategoriesFormPage extends TestBase {

    @Test
    void categoriesCheck(){
        MainPage mainPage = new MainPage(BASE_URL);
        step("Проверка наличия на главной странице меню Категории", () -> {
            $(".SnowCategoriesMenu_SnowCategoriesMenu__categoryList__1xev4").find(byText("Категории")).shouldBe(Condition.visible);
        });
        step("Проверка в меню Категории небходимого контента", () -> {
            $(".SnowCategoriesMenu_SnowCategoriesMenu__categoryList__1xev4").find(byText("Категории")).click();
            $(".SnowWaterfallTabs_SnowWaterfallTabs__root__1vw7k").shouldHave(Condition.text("Подобрали для вас"));

        });
        step("Проверка в категории Компьютеры и офис фильтра Бесплатная доставка", () -> {
            $(".SnowCategories_SnowCategories__root__53ns3").find(byText("Компьютеры и офис")).click();
            $(".SnowSearchFilter_Block__block__42qt8").shouldHave(Condition.text("Бесплатная доставка"));
        });
    }
}
