package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FooterTest {

    @BeforeEach
    void setUp(){
        open("https://aliexpress.ru/");
        Configuration.holdBrowserOpen = true;
    }
    @ValueSource(strings = {"Политика Конфиденциальности", "Карта сайта", "Пользовательские соглашения"})
    @ParameterizedTest(name = "Проверка наличия в footer ссылок {0}")
    void testFooterList(String element){
        $(".SnowFooter_PaymentCopyright__copyrightContainer__vldyy").$(byText(element)).shouldBe(visible);
    }
}
