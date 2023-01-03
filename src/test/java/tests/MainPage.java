package tests;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    public MainPage(String url){
        open(url);
    }

}
