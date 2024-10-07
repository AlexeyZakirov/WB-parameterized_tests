package pages;

import pages.components.CatalogOfCards;
import pages.components.FiltersBlockDropdown;
import pages.components.Header;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class VehiclesCatalogPage {
    public final String vehicleCatalogEndpoint = "/catalog/transportnye-sredstva";
    private final CatalogOfCards catalogOfCards = new CatalogOfCards();
    private final FiltersBlockDropdown filtersBlockDropdown = new FiltersBlockDropdown();
    private final Header header = new Header();

    public void openVehicleCatalog(){
        open(vehicleCatalogEndpoint);
        sleep(500);
    }

    public VehiclesCatalogPage filterCardsBySeller(String seller){
        filtersBlockDropdown.filterCardsBySeller(seller);
        return this;
    }

    public VehiclesCatalogPage filterCardsByMinAndMaxPrice(String minPrice, String maxPrice){
        filtersBlockDropdown.filterCardsByMinAndMaxPrice(minPrice, maxPrice);
        return this;
    }

    public void checkNumberOfCardsIsGreaterThanZero() {
        catalogOfCards.checkNumberOfCardsIsGreaterThanZero();
    }

    public void checkCurrencyOfCard(String currency) {
        catalogOfCards.checkCurrencyOfCard(currency);
    }

    public VehiclesCatalogPage setCurrencyOfCountry(String country){
        header.setCurrencyOfCountry(country);
        return this;
    }

    public void goInsideTheCard(String nameCard) {
        catalogOfCards.goInsideTheCard(nameCard);
    }

}
