package serenitylabs.tutorials.vetclinic.enumerations.colours;

public enum Colour {
    Red(true, "Green"),
    Orange(false, "Violet"),
    Yellow(true, "Blue"),
    Green(false, "Red"),
    Blue(true, "Yellow"),
    Violet(false, "Orange"),
    Black(false, "White"),
    White(false, "Black");

    private Boolean primary;
    private String opposite;


    Colour(Boolean primary, String opposite) {
        this.primary=primary;
        this.opposite=opposite;
    }

    public Boolean isPrimary() {
        return primary;
    }

    public String opposite() {
        return opposite;
    }
}
