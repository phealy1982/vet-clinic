package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by peterhealy on 16/10/2016.
 */
public class CheckedInResponse implements BookingResponse {

    private final Integer bookingNumber;
    private final Pet pet;

    public CheckedInResponse(Integer bookingNumber, Pet pet) {

        this.bookingNumber = bookingNumber;
        this.pet = pet;
    }

    @Override public boolean isConfirmed() {
        return true;
    }

    @Override public boolean isOnWaitingList() {
        return false;
    }

    @Override public Integer bookingNumber() {
        return bookingNumber;
    }

    @Override public Pet pet() {
        return pet;
    }
}
