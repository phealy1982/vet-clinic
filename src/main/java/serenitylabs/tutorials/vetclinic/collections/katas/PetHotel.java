package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.TreeMap;

/**
 * Created by 66515 on 25/08/2016.
 */
public class PetHotel {

    private TreeMap<String,Pet> pets;


    public PetHotel() {
    }

    public TreeMap<String, Pet> getPets() {
        return pets;
    }

    public BookingResponse checkIn(Pet petToCheckIn) {
        if(pets==null){
            pets=new TreeMap<>();
            addPetIfDoesNotExisitAndHotelNotFull(petToCheckIn);
        } else {
            addPetIfDoesNotExisitAndHotelNotFull(petToCheckIn);
        }

        return new BookingResponse(petToCheckIn, "1");

    }

    private void addPetIfDoesNotExisitAndHotelNotFull(Pet petToCheckIn) {

        Pet petFromMap = pets.get(petToCheckIn.getName());
        Integer numberOfPetsCheckedIn = pets.size();

        if(petFromMap==null && numberOfPetsCheckedIn <20) {
            pets.put(petToCheckIn.getName(),petToCheckIn);
        }
    }
}
