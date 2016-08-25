package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by 66515 on 25/08/2016.
 */
public class BookingResponse {


    private Pet pet;
    private String bookingNumber;


    public BookingResponse(Pet petToCheckIn, String bookingNumber) {
        this.pet=petToCheckIn;
        this.bookingNumber=bookingNumber;
    }

    public Pet getPet() {
        return pet;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public boolean isConfirmed() {
        return true;
    }
}
