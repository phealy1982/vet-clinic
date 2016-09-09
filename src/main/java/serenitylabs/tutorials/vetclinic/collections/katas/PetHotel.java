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

    public Booking checkIn(Pet pet) {
        return  hasCapacity()
                ? createReservation(pet)
                : addPetToWaitingList(pet);
    }

    private boolean hasCapacity() {
        return pets.size()<HOTEL_CAPACITY;
    }

    private Booking createReservation(Pet pet) {
        pets.put(pet.getName(), pet);
        return new BookingConfirmed(Math.random(), pet);
    }

    private Booking addPetToWaitingList(Pet pet) {
        waitingList.add(pet);
        return new BookingOnWaitingList(Math.random(), pet);
    }

    public List<Pet> getPetsInAlphabethicalOrder(){
        return new ArrayList<>(pets.values());
    }

    public void checkout(String petName) {
        pets.remove(petName);
        checkInNextOnWaitingList();
    }

    private void checkInNextOnWaitingList() {
        if(petOnWaitingList()){
            checkIn(waitingList.poll());
        }
    }

    private boolean petOnWaitingList() {
        return !waitingList.isEmpty();
    }


}
