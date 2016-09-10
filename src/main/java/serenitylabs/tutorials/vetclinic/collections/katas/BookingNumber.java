package serenitylabs.tutorials.vetclinic.collections.katas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by peterhealy on 10/09/2016.
 */
public class BookingNumber {

    public static final AtomicInteger bookingNumber = new AtomicInteger(1);

    public static Integer getNextBookingNumber() {
        return bookingNumber.getAndAdd(1);
    }
}
