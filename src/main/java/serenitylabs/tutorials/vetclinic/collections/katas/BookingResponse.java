package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by 66515 on 06/09/2016.
 */
public interface BookingResponse {

    boolean isConfirmed();
    boolean isOnWaitingList();
    Integer bookingNumber();
    Pet pet();
}
