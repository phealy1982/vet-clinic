package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.*;

/**
 * Created by 66515 on 06/09/2016.
 */
public class PetHotel {

    public final static Integer HOTEL_CAPACITY = 20;

    Map<String, Pet> pets = new TreeMap<>();

    Queue<Pet> waitingList = new LinkedList<>();

    public Map<String, Pet> getPets() {
        return pets;
    }

    public BookingResponse checkIn(Pet pet) {

        if(pets.size()<HOTEL_CAPACITY){
            pets.put(pet.getName(), pet);
            return new BookingResponse(Math.random(), pet, true, false);
        } else {
            waitingList.add(pet);
            return new BookingResponse(Math.random(), pet, false, true);
        }
    }

    public List<Pet> getPetsInAlphabethicalOrder(){

        List<Pet> sortedPets = new ArrayList<>();

        for(Pet pet : pets.values()){
            sortedPets.add(pet);
        }

        Collections.sort(sortedPets, Comparator.comparing(Pet::getName));

        return sortedPets;

    }

    public void checkout(String petName) {
        Pet petToCheckOut = pets.get(petName);

        if(petToCheckOut != null){
            pets.remove(petName);
        }

        if(waitingList.peek() != null){
            Pet petFromWaitingList = waitingList.poll();
            pets.put(petFromWaitingList.getName(), petFromWaitingList);
        }
    }
}
