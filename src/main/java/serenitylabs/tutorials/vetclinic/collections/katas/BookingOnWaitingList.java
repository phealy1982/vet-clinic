package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by 66515 on 09/09/2016.
 */
public class BookingOnWaitingList implements  Booking{
    private final Double bookingNumber;
    private final Pet pet;

    public BookingOnWaitingList(Double bookingNumber, Pet pet) {
        this.bookingNumber = bookingNumber;
        this.pet = pet;
    }

    @Override
    public Boolean isConfirmed() {
        return false;
    }

    @Override
    public Double getBookingNumber() {
        return bookingNumber;
    }

    @Override
    public Pet getPet() {
        return pet;
    }

    @Override
    public Boolean isOnWaitingList() {
        return true;
    }
}
