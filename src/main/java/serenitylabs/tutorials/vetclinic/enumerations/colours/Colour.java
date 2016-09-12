package serenitylabs.tutorials.vetclinic.enumerations.colours;

public enum Colour {

    Red(true), Orange(false), Yellow(true), Green(false),
    Blue(true), Violet(false), Black(false), White(false);

    private Boolean primary;
    private Colour opposite;

    static {
        Red.opposite = Green;
        Orange.opposite = Violet;
        Yellow.opposite = Blue;
        Green.opposite = Red;
        Blue.opposite = Yellow;
        Violet.opposite = Orange;
        Black.opposite = White;
        White.opposite = Black;
    }

    Colour(Boolean primary) {
        this.primary=primary;
    }

    public Boolean isPrimary() {
        return primary;
    }

    public Colour opposite() {
        return opposite;
    }
}
