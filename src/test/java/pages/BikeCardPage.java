package pages;

import pages.components.Card;

public class BikeCardPage extends Card {

    private final String volume;
    private final String engine;
    private final String capacity;
    private final String numberOfClockCycles;
    private final String typeOfCoolingSystem;
    private final String typeOfDrive;

    public BikeCardPage(String nameCard, String article, String price, String volume, String engine,
                        String capacity, String numberOfClockCycles, String typeOfCoolingSystem, String typeOfDrive) {
        this.nameCard = nameCard;
        this.article = article;
        this.price = price;
        this.volume = volume;
        this.engine = engine;
        this.capacity = capacity;
        this.numberOfClockCycles = numberOfClockCycles;
        this.typeOfCoolingSystem = typeOfCoolingSystem;
        this.typeOfDrive = typeOfDrive;
        this.typeOfCard = "Мототехника";
    }

    public void checkProductParamsTable(){
        checkRowOfTable("Артикул", this.article);
        checkRowOfTable("Объем двигателя (куб.см)", this.volume);
        checkRowOfTable("Мощность двигателя (л.с.)", this.capacity);
        checkRowOfTable("Тип системы охлаждения", this.typeOfCoolingSystem);
        checkRowOfTable("Двигатель", this.engine);
        checkRowOfTable("Количество тактов двигателя", this.numberOfClockCycles);
        checkRowOfTable("Тип привода мототехники", this.typeOfDrive);
    }

}
