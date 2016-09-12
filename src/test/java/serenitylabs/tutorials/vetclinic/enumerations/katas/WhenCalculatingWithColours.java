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
    @Test
    public void should_know_about_all_the_main_colours() {

        List<String> colours = new ArrayList<>();

        for(Colour colour : Colour.values()){
            colours.add(colour.name());
        }

        assertThat(colours).contains("Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Black", "White");
    }

    @Test
    public void should_identify_primary_colours() {

        assertThat(Colour.Red.isPrimary()).isTrue();
        assertThat(Colour.Yellow.isPrimary()).isTrue();
        assertThat(Colour.Blue.isPrimary()).isTrue();
    }

    @Test
    public void should_identify_non_primary_colours() {

        assertThat(Colour.Black.isPrimary()).isFalse();
        assertThat(Colour.White.isPrimary()).isFalse();
        assertThat(Colour.Violet.isPrimary()).isFalse();
        assertThat(Colour.Green.isPrimary()).isFalse();
        assertThat(Colour.Orange.isPrimary()).isFalse();
    }

    @Test
    public void black_and_white_are_not_considered_primary() {
        assertThat(Colour.Black.isPrimary()).isFalse();
        assertThat(Colour.White.isPrimary()).isFalse();
    }

    @Test
    public void red_is_the_opposite_of_green() {
        assertThat(Colour.Red.opposite()).isEqualTo(Colour.Green.name());
    }

    @Test
    public void blue_is_the_opposite_of_orange() {
        assertThat(Colour.Blue.opposite()).isEqualTo(Colour.Orange.name());
    }

    @Test
    public void yellow_is_the_opposite_of_violet() {
        assertThat(Colour.Yellow.opposite()).isEqualTo(Colour.Violet.name());
    }

    @Test
    public void black_is_the_opposite_of_white() {
        assertThat(Colour.Black.opposite()).isEqualTo(Colour.White.name());
    }

    @Test
    public void opposite_colours_are_symmetric() {
        assertThat(Colour.Black.opposite()).isEqualTo(Colour.White.name());
        assertThat(Colour.White.opposite()).isEqualTo(Colour.Black.name());
    }

    /**
     * This is an example of an alternative approach using JUnitParam
     */
    @Parameters({"Red,    Green",
            "Blue,   Orange",
            "Violet, Yellow",
            "Black,  White"})
    @Test
    public void should_identify_opposite_colours(Colour colour, Colour expectedOpposite) throws Exception {
    }

}
