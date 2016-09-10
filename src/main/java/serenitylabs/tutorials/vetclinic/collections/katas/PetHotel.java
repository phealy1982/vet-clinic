package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.time.Period;
import java.util.*;

/**
 * Created by 66515 on 06/09/2016.
 */
public class PetHotel {


    public static final int HOTEL_CAPACITY = 20;
    private Map<String, Pet> pets;
    private Queue<Pet> waitingList;

    public PetHotel() {
        this.pets = new TreeMap<>();
        this.waitingList = new LinkedList<>();
    }

    public List<Pet> getPets() {
        return new ArrayList<>(pets.values());
    }

    public BookingResponse checkIn(Pet pet) {
        return  hotelAtCapaciy() ?
                addPetToWaitingList(pet) :
                createReservation(pet);
    }

    private BookingResponse createReservation(Pet pet) {
        pets.put(pet.getName(), pet);
        return new BookingConfirmed(pet);
    }

    private BookingResponse addPetToWaitingList(Pet pet) {
        waitingList.add(pet);
        return new WaitingListConfirmation(pet);

    }

    private Boolean hotelAtCapaciy(){
        return pets.size() == HOTEL_CAPACITY;
    }

    public List<Pet> getPetsOnWaitingList() {
        return new ArrayList<>(waitingList);
    }

    public void checkOut(String petName) {
        pets.remove(petName);
        checkInNextPetOnWaitingList();
    }

    private void checkInNextPetOnWaitingList() {
        if(petOnWaitingList()){
            checkIn(waitingList.poll());
        }
    }

    private boolean petOnWaitingList() {
        return !waitingList.isEmpty();
    }
}
