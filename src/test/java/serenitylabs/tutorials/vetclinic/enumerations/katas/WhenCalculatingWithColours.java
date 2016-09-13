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

        assertThat(colours).contains("Red", "Orange", "Yellow", "Green", "Blue",
            "Violet", "Black", "White");
    }

    @Test
    @Parameters({"Red", "Yellow", "Blue"})
    public void should_identify_primary_colours(Colour colour) {
        assertThat(colour.isPrimary()).isTrue();
    }

    @Test
    @Parameters({"Orange", "Violet", "Black", "White", "Green"})
    public void should_identify_non_primary_colours(Colour colour) {
        assertThat(colour.isPrimary()).isFalse();
    }

    @Test
    @Parameters({"Red",    "Green",
        "Blue",   "Yellow",
        "Violet", "Orange",
        "Black",  "White"})
    public void opposite_colours_are_symmetric(Colour colour) {
            assertThat(colour.opposite().opposite()).isEqualTo(colour);
    }


    @Test
    @Parameters({"Red,    Green",
        "Blue,   Yellow",
        "Violet, Orange",
        "Black,  White"})
    public void should_identify_opposite_colours(Colour colour, Colour expectedOpposite) throws Exception {
        assertThat(colour.opposite()).isEqualTo(expectedOpposite);
        assertThat(expectedOpposite.opposite()).isEqualTo(colour);
    }

}
