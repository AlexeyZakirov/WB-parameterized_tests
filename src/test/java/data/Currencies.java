package data;

public enum Currencies {

    BYN("р."),
    KZT("тг."),
    AMD("драм"),
    KGS("сом"),
    UZS("сум"),
    RUB("₽");

    private final String currency;

    Currencies(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
