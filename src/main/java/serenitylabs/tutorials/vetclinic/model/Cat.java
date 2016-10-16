package serenitylabs.tutorials.vetclinic.model;

/**
 * Created by peterhealy on 26/09/2016.
 */
public class Cat implements Animal {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override public void speak() {
        System.out.println("Meow name is " + name);
    }
}
