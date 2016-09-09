package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by 66515 on 06/09/2016.
 */
public class BookingResponse implements Booking {

    Double bookingNumber;
    Pet pet;
    Boolean confirmed;
    Boolean onWaitingList;

    public BookingResponse(Double bookingNumber, Pet pet, Boolean confirmed, Boolean onWaitingList) {
        this.bookingNumber = bookingNumber;
        this.pet = pet;
        this.confirmed = confirmed;
        this.onWaitingList = onWaitingList;
    }

    @Override
    public Boolean isConfirmed(){
        return confirmed;
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
    public Boolean isOnWaitingList(){
        return onWaitingList;
    }
}
