package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class ShopTest extends TestBase {
    @Test
    void shopTest(){
//        step("Открываем сайт", () -> {
//            open("https://aliexpress.ru/");
//            Configuration.holdBrowserOpen = true;
//        });
        step("Ищем товар", () -> {
            $("#searchInput").setValue("Pixel 7").pressEnter();
            $(byXpath("//div[@data-product-id='1005004818013867']//a")).click();

        });
        step("Добавляем товар в корзину", () -> {
            switchTo().window(1);
            $(".SnowFixedButtons_SnowFixedButtons__buttonWrap__fne75").find(byText("В корзину")).click();
        });
        step("Переходим в корзину", () -> {
            $(".SnowFixedButtons_SnowFixedButtons__buttonWrap__fne75").find(byText("Перейти")).click();
            $(".ShoppingcartItemList_ProductCard__productNameLink__1nl31").shouldHave(text("Новый смартфон Google Pixel 7, оригинальный и новый телефон"));
        });
        step("Проверка, что в корзине находится нужный товар", () -> {
            $(".ShoppingcartItemList_ProductCard__productNameLink__1nl31").shouldHave(text("Новый смартфон Google Pixel 7, оригинальный и новый телефон"));
            $(".ShoppingcartItemList_Store__buyFromSeller__12j25").find(byText("Заказать у этого продавца")).click();
        });

    }

}
