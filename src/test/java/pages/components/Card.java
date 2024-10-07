package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

abstract public class Card {
    protected final SelenideElement productParamsTable = $("table.product-params__table");
    protected String productParamsRow = ".product-params__row";
    protected String nameCard;
    protected String price;
    protected String article;
    protected String typeOfCard;

    public String getNameCard() {
        return nameCard;
    }

    public String getPrice() {
        return price;
    }

    public String getTypeOfCard() {
        return typeOfCard;
    }

    abstract public void checkProductParamsTable();

    protected void checkRowOfTable(String key, String value){
        productParamsTable.$(byText(key)).closest(productParamsRow).shouldHave(text(value));
    }

    public void checkTypeOfCard(String typeOfCard){
        $(".product-page__breadcrumbs").shouldHave(text(typeOfCard));
    }


    public void checkCardPrice(String price){
        $(".product-page__aside-container .price-block__final-price").shouldHave(text(price));
    }

    public void checkSellerOfCard(String seller){
        $(".product-page__aside-container").shouldHave(text(seller));
    }

    @Override
    public String toString() {
        return nameCard;
    }
}
