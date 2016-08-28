package serenitylabs.tutorials.vetclinic;

/**
 * Created by peterhealy on 28/08/2016.
 */
public class BookingResponse {

    private boolean confirmed;
    private Double bookingNumber;
    private Pet pet;
    private boolean onWaitingList;


    public BookingResponse(Double bookingNumber, Pet petToCheckIn, boolean confirmed, boolean onWaitingList) {
        this.bookingNumber = bookingNumber;
        this.pet = petToCheckIn;
        this.confirmed = confirmed;
        this.onWaitingList = onWaitingList;

    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public boolean isOnWaitingList() {
        return onWaitingList;
    }
}
