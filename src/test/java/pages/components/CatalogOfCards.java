package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogOfCards {
    private final ElementsCollection allCardsOnList = $$("div.product-card-list article.product-card");
    private final SelenideElement priceOfCardOnList = $("div.product-card-list p.product-card__price"),
            listOfCards = $("div.product-card-list");
    private final String cardWrapper = ".product-card__wrapper";

    public void checkNumberOfCardsIsGreaterThanZero() {
        allCardsOnList.shouldBe(sizeGreaterThan(0));
    }

    public void checkCurrencyOfCard(String currency) {
        priceOfCardOnList.shouldHave(text(currency));
    }

    public void goInsideTheCard(String nameCard) {
        listOfCards.$(byText(nameCard)).closest(cardWrapper).scrollTo().click();
    }
}
