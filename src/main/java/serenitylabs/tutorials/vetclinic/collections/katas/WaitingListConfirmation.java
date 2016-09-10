package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by peterhealy on 10/09/2016.
 */
public class WaitingListConfirmation implements BookingResponse {
    private final Pet pet;

    public WaitingListConfirmation(Pet pet) {
        this.pet = pet;
    }

    @Override public Boolean isConfirmed() {
        return false;
    }

    @Override public Boolean isOnWaitingList() {
        return true;
    }

    @Override public Integer getBookingNumber() {
        return BookingNumber.getNextBookingNumber();
    }

    @Override public Pet getPet() {
        return pet;
    }
}
