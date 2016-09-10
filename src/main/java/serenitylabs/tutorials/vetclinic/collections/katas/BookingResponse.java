package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by peterhealy on 10/09/2016.
 */
public interface BookingResponse {

    Boolean isConfirmed();
    Boolean isOnWaitingList();
    Integer getBookingNumber();
    Pet getPet();


}
