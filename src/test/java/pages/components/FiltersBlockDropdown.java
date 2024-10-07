package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FiltersBlockDropdown {
    private final SelenideElement blockDropdown = $(".filters-block__dropdown"),
    filterListOfSellers = $(".filter__list"),
    submitFilterButton = $(".filter-btn__main"),
    inputMinPrice = $(".j-price[name='startN']"),
    inputMaxPrice = $(".j-price[name='endN']");

    private void submitFilter(){
        submitFilterButton.click();
    }

    public void filterCardsBySeller(String seller){
        blockDropdown.$(byText("Продавец")).hover();
        filterListOfSellers.$(byText(seller)).click();
        submitFilter();
    }

    public void filterCardsByMinAndMaxPrice(String minPrice, String maxPrice){
        blockDropdown.$(byText("Цена, ₽")).hover();
        inputMinPrice.setValue(minPrice);
        inputMaxPrice.setValue(maxPrice);
        submitFilter();
    }
}
