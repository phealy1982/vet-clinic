package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.*;

/**
 * Created by 66515 on 06/09/2016.
 */
public class PetHotel {


    private static final int CAPACITY = 20;
    private Map<String, Pet> pets = new TreeMap<>();
    private Queue<Pet> waitingList = new LinkedList<>();

    public List<Pet> getPets() {
        return new ArrayList<>(pets.values());
    }

    public BookingResponse checkIn(Pet pet) {
        return atCapacity() ?
            putOnWaitingList(pet) :
            carryOutCheckIn(pet);
    }

    private BookingResponse carryOutCheckIn(Pet pet) {
        pets.put(pet.getName(), pet);
        return new CheckedInResponse(nextBookingNumber(), pet);
    }

    private BookingResponse putOnWaitingList(Pet pet) {
        waitingList.add(pet);
        return new WaitingListResponse(nextBookingNumber(), pet);
    }

    private boolean atCapacity() {
        return pets.size() == CAPACITY;
    }

    private Integer nextBookingNumber() {
        return 1;
    }

    public List<Pet> waitingList() {
        return new ArrayList<>(waitingList);
    }

    public void checkOut(String name) {
        pets.remove(name);
        checkInPetFromWaitingList();
    }

    private void checkInPetFromWaitingList() {
        if (waitingList.size() > 0) {
            checkIn(waitingList.poll());
        }
    }
}
