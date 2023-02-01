package hu.preznyak.hotel.cinnamon.data;

public enum Equipment {
    COFFEE_MACHINE("Coffee machine"), PRIVATE_TOILET("Private toilet"), SHOWER("Shower"), TUB("Tub"),REFRIDGERATOR("Refrigerator");
    private String name;

    Equipment(String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }
}
