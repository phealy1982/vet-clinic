package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.*;

/**
 * Created by 66515 on 06/09/2016.
 */
public class PetHotel {

    Map<String, Pet> pets = new TreeMap<>();


    public Map<String, Pet> getPets() {
        return pets;
    }

    public BookingResponse checkIn(Pet pet) {
        pets.put(pet.getName(), pet);
        return null;
    }

    public List<Pet> getPetsInAlphabethicalOrder(){

        List<Pet> sortedPets = new ArrayList<>();

        for(Pet pet : pets.values()){
            sortedPets.add(pet);
        }

        Collections.sort(sortedPets, Comparator.comparing(Pet::getName));

        return sortedPets;

    }
}
