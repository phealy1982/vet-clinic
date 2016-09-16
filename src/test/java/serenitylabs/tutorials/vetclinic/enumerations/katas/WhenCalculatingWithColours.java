package serenitylabs.tutorials.vetclinic.enumerations.katas;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.enumerations.colours.Colour;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class WhenCalculatingWithColours {

    @Test public void should_have_all_main_colours() throws Exception {

        List<String> colours = new ArrayList<>();

        for(Colour colour : Colour.values()){
            colours.add(colour.name());
        }

        assertThat(colours)
                .contains("Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Black", "White");
    }

    @Test
    @Parameters({
            "Red",
            "Yellow",
            "Blue"})
    public void should_know_primary_colours(Colour colour) throws Exception {
        assertThat(colour.isPrimary()).isTrue();
    }

    @Test
    @Parameters({
            "Orange",
            "Green",
            "Violet",
            "White",
            "Black"})
    public void should_know_when_colours_are_not_primary(Colour colour) throws Exception {
        assertThat(colour.isPrimary()).isFalse();
    }

    @Test
    @Parameters({"Red, Green",
            "Orange, Violet",
            "Yellow, Blue",
            "Black, White",
            "Green, Red",
            "Violet, Orange",
            "Blue, Yellow",
            "White, Black"})
    public void should_know_each_colours_opposite(Colour colour, Colour opposite) throws Exception {
        assertThat(colour.opposite()).isEqualTo(opposite);
    }

    @Test
    @Parameters({"Red",
            "Orange",
            "Yellow",
            "Black",
            "Green",
            "Violet",
            "Blue",
            "White"})
    public void opposite_colours_should_be_symmetric(Colour colour) throws Exception {
        assertThat(colour.opposite().opposite()).isEqualTo(colour);

    }
}
