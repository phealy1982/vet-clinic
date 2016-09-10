package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by peterhealy on 10/09/2016.
 */
public class BookingConfirmed implements BookingResponse{


    private Pet pet;

    public BookingConfirmed(Pet pet) {
        this.pet = pet;
    }

    @Override public Boolean isConfirmed() {
        return true;
    }

    @Override public Boolean isOnWaitingList() {
        return null;
    }

    @Override public Integer getBookingNumber() {
        return BookingNumber.getNextBookingNumber();
    }

    @Override public Pet getPet() {
        return pet;
    }
}
