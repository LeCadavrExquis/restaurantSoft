package model;

public enum DaniaType {
    PIZZA("pizza", 32.0),
    DRINK("napój", 5.5),
    PASTA("makaron", 27),
    PIEROGI("pierogi", 25.0),
    NALESNIK ("nalesnik", 17.5);

    public String name;
    public double price;

    private DaniaType(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
