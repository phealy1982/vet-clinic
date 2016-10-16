package serenitylabs.tutorials.vetclinic.model;

/**
 * Created by peterhealy on 26/09/2016.
 */
public class Dog implements Animal {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override public void speak() {
        System.out.println("Ruff, my name is " + name);
    }
}
