package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by 66515 on 09/09/2016.
 */
public interface Booking {
    Boolean isConfirmed();

    Double getBookingNumber();

    Pet getPet();

    Boolean isOnWaitingList();
}
