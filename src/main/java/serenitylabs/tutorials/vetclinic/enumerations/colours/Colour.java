package serenitylabs.tutorials.vetclinic.enumerations.colours;

public enum Colour {
    Red(true), Orange(false), Yellow(true), Green(false), Blue(true),
    Violet(false), Black(false), White(false);

    private boolean primary;
    private Colour opposite;


    static {
        Red.opposite = Green;
        Green.opposite = Red;
        Black.opposite = White;
        White.opposite = Black;
        Blue.opposite = Yellow;
        Yellow.opposite = Blue;
        Orange.opposite = Violet;
        Violet.opposite = Orange;
    }

    Colour(boolean primary) {
        this.primary = primary;
    }

    public boolean isPrimary() {
        return primary;
    }

    public Colour opposite() {
        return opposite;
    }
}
