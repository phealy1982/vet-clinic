package serenitylabs.tutorials.vetclinic.model;

import org.junit.Test;

/**
 * Created by peterhealy on 26/09/2016.
 */
public class DogTest {


    @Test public void a_dog_is_an_animal() throws Exception {
        Animal dog = new Dog("Fido");
        dog.speak();
    }

    @Test public void a_cat_is_an_animal() throws Exception {
        Animal cat = new Cat("Felix");
        cat.speak();
    }
}
