package serenitylabs.tutorials.vetclinic.collections.exercises;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class WhenWorkingWithASetOfPets {

    @Test
    public void should_add_Fido_to_the_set_of_pets() {
        Set<String> names = Sets.newHashSet();

        names.add("Fido");

        assertThat(names).contains("Fido");
    }

    @Test
    public void a_set_of_pets_should_not_contain_duplicates() {
        Set<String> names = Sets.newHashSet();

        names.add("Fido");
        names.add("Felix");
        names.add("Fido");

        assertThat(names).containsOnlyOnce("Felix", "Fido");


    }

    @Test
    public void adding_several_pets() {
        Set<String> names = Sets.newHashSet("Fido","Felix");

        names.addAll(Sets.newHashSet("Felix","Spot"));

        assertThat(names).containsOnlyOnce("Felix", "Spot", "Fido");

    }


}
