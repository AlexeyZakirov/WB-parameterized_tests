package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Header {
    private final SelenideElement headerCurrenciesWrap = $(".header__wrap"),
            countryWrap = $(".country__wrap");

    public void setCurrencyOfCountry(String country){
        headerCurrenciesWrap.hover();
        countryWrap.$(byText(country)).click();
    }
}
