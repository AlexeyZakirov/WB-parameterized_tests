import data.Currencies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.BikeCardPage;
import pages.VehiclesCatalogPage;
import pages.WaterPoweredCardPage;
import pages.components.Card;

import java.util.stream.Stream;


public class WbTransportTests extends TestBase {

    VehiclesCatalogPage vehicles = new VehiclesCatalogPage();

    @BeforeEach
    void setUp() {
        vehicles.openVehicleCatalog();
    }

    @ValueSource(strings = {
            "Bike4youru",
            "Активный Отдых"
    })
    @Tag("SMOKE")
    @ParameterizedTest(name = "У продавца с именем {0} должны иметься товары в каталоге")
    void cardsShouldBeVisibleBySellersTest(String seller) {
        vehicles.filterCardsBySeller(seller)
                .checkNumberOfCardsIsGreaterThanZero();
    }

    @CsvSource(value = {
            "34200 , 526980",
            "34200 , 34200",
            "526980 , 526980"
    })
    @Tag("SMOKE")
    @ParameterizedTest(name = "С минимальной ценой, равной {0}, и максимальной ценой, равной {1}, должны иметься товары")
    void boundaryValuesOfPriceTest(String minimumPrice, String maximumPrice) {
        vehicles.filterCardsByMinAndMaxPrice(minimumPrice, maximumPrice)
                .checkNumberOfCardsIsGreaterThanZero();
    }

    @EnumSource(Currencies.class)
    @Tag("SMOKE")
    @ParameterizedTest(name = "При выборе страны {0} у товаров должна иметься соответствующая валюта")
    void changeCurrencyTest(Currencies currencies) {
        vehicles.setCurrencyOfCountry(currencies.name())
                .checkCurrencyOfCard(currencies.getCurrency());
    }

    static Stream<Arguments> cardProductParamsBySellerTest() {
        return Stream.of(
                Arguments.of("Bike4youru", new BikeCardPage("Мопед SCOUT 11", "234976129", "96 140",
                        "48 куб. см", "бензин", "5 лс",
                        "4-х тактный", "воздушный", "цепной")),

                Arguments.of("Активный Отдых", new WaterPoweredCardPage("Лодка RAPID 380 Зеленый Пиксель",
                        "265269787", "98 820", "RAPID 380", "2024", "381 мм",
                        "20 лс", "38 кг", "5+1")),

                Arguments.of("Bike4youru", new BikeCardPage("Мотоцикл 300 DF BIG BORE (XF300-B) (CBS300 с балансиром)",
                        "234975880", "317 590",
                        "300 куб. см", "бензин", "24 лс",
                        "4-х тактный", "водяной", "цепной"))

        );
    }

    @MethodSource()
    @Tag("REGRESS")
    @ParameterizedTest(name = "У продавца {0} должен иметься товар {1} с соответствующими характеристиками и ценой")
    void cardProductParamsBySellerTest(String seller, Card card) {
        vehicles.filterCardsBySeller(seller)
                .goInsideTheCard(card.getNameCard());

        card.checkTypeOfCard(card.getTypeOfCard());
        card.checkCardPrice(card.getPrice());
        card.checkSellerOfCard(seller);
        card.checkProductParamsTable();
    }

}