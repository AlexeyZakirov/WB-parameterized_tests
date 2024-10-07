package pages;

import pages.components.Card;

public class WaterPoweredCardPage extends Card {
    private final String model;
    private final String yearOfModel;
    private final String transomHeight;
    private final String maxCapacity;
    private final String weight;
    private final String numberOfSeats;

    public WaterPoweredCardPage(String nameCard, String article, String price, String model, String yearOfModel,
                                String transomHeight, String maxCapacity, String weight, String numberOfSeats) {
        this.nameCard = nameCard;
        this.article = article;
        this.price = price;
        this.model = model;
        this.yearOfModel = yearOfModel;
        this.transomHeight = transomHeight;
        this.maxCapacity = maxCapacity;
        this.weight = weight;
        this.numberOfSeats = numberOfSeats;
        this.typeOfCard = "Водомоторная техника";
    }

    public void checkProductParamsTable(){
        checkRowOfTable("Артикул", this.article);
        checkRowOfTable("Модель транспортного средства", this.model);
        checkRowOfTable("Модельный год", this.yearOfModel);
        checkRowOfTable("Высота транца", this.transomHeight);
        checkRowOfTable("Максимальная мощность мотора", this.maxCapacity);
        checkRowOfTable("Вес (кг)", this.weight);
        checkRowOfTable("Количество мест", this.numberOfSeats);
    }
}
