package serenitylabs.tutorials.vetclinic.enumerations.katas;

import junitparams.JUnitParamsRunner;
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

    @Test public void should_know_primary_colours() throws Exception {
        assertThat(Colour.Red.isPrimary()).isTrue();
        assertThat(Colour.Yellow.isPrimary()).isTrue();
        assertThat(Colour.Blue.isPrimary()).isTrue();

    }

    @Test public void should_know_when_colours_are_not_primary() throws Exception {
        assertThat(Colour.Orange.isPrimary()).isFalse();
        assertThat(Colour.Green.isPrimary()).isFalse();
        assertThat(Colour.Violet.isPrimary()).isFalse();
        assertThat(Colour.Black.isPrimary()).isFalse();
        assertThat(Colour.White.isPrimary()).isFalse();
    }

    @Test public void should_know_each_colours_opposite() throws Exception {
        assertThat(Colour.Red.opposite()).isEqualTo(Colour.Green);
        assertThat(Colour.Orange.opposite()).isEqualTo(Colour.Violet);
        assertThat(Colour.Yellow.opposite()).isEqualTo(Colour.Blue);
        assertThat(Colour.Green.opposite()).isEqualTo(Colour.Red);
        assertThat(Colour.Blue.opposite()).isEqualTo(Colour.Yellow);
        assertThat(Colour.Black.opposite()).isEqualTo(Colour.White);
        assertThat(Colour.White.opposite()).isEqualTo(Colour.Black);
    }
}
