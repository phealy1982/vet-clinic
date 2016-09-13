package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by peterhealy on 10/09/2016.
 */
public class BookingConfirmed implements BookingResponse{


    private Pet pet;
    private Integer bookingNumber;


    public BookingConfirmed(Pet pet) {
        this.pet = pet;
        this.bookingNumber = BookingNumber.getNextBookingNumber();
    }

    @Override public Boolean isConfirmed() {
        return true;
    }

    @Override public Boolean isOnWaitingList() {
        return false;
    }

    @Override public Integer getBookingNumber() {
        return bookingNumber;
    }

    @Override public Pet getPet() {
        return pet;
    }
}
