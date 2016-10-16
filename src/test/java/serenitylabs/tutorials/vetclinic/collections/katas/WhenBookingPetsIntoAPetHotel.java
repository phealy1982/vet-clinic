package serenitylabs.tutorials.vetclinic.collections.katas;

import org.junit.Before;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Pet;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenBookingPetsIntoAPetHotel {

    public static final int CAPACITY = 20;
    private PetHotel petHotel;
    private Pet fido = Pet.dog().named("Fido");
    private Pet rover = Pet.dog().named("Rover");
    private PetHotel petHotelAtCapacity;

    @Before
    public void before(){
        petHotel= new PetHotel();
        petHotelAtCapacity = hotelAtCapacity();
    }

    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {
        assertThat(petHotel.getPets()).isEmpty();
    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
        petHotel.checkIn(fido);
        assertThat(petHotel.getPets()).contains(fido);
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {
        petHotel.checkIn(fido);
        petHotel.checkIn(rover);
        assertThat(petHotel.getPets()).contains(fido, rover);
    }

    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {
        petHotel.checkIn(rover);
        petHotel.checkIn(rover);
        assertThat(petHotel.getPets()).containsOnlyOnce(rover);
    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {
        petHotel.checkIn(rover);
        petHotel.checkIn(fido);
        assertThat(petHotel.getPets()).containsSequence(fido, rover);
    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {
        BookingResponse bookingResponse = petHotel.checkIn(fido);
        assertThat(bookingResponse.bookingNumber()).isNotNull();
        assertThat(bookingResponse.pet()).isEqualTo(fido);
        assertThat(bookingResponse.isConfirmed()).isTrue();
    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {
        petHotelAtCapacity.checkIn(fido);
        assertThat(petHotelAtCapacity.getPets().size()).isEqualTo(CAPACITY);
    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {
        BookingResponse bookingResponse = petHotelAtCapacity.checkIn(fido);
        assertThat(bookingResponse.isOnWaitingList()).isEqualTo(true);
    }

    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {
        petHotelAtCapacity.checkIn(fido);
        assertThat(petHotelAtCapacity.waitingList()).contains(fido);
    }

    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {
        petHotelAtCapacity.checkIn(fido);
        petHotelAtCapacity.checkOut("FidoClone1");
        assertThat(petHotelAtCapacity.getPets()).contains(fido);
    }


    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {
        petHotelAtCapacity.checkIn(fido);
        petHotelAtCapacity.checkIn(rover);
        petHotelAtCapacity.checkOut("FidoClone1");
        assertThat(petHotelAtCapacity.getPets()).contains(fido);
    }

    private PetHotel hotelAtCapacity() {
        PetHotel petHotel = new PetHotel();

        for(int i = 0; i< CAPACITY; i++){
            petHotel.checkIn(Pet.dog().named("FidoClone"+i));
        }
        assertThat(petHotel.getPets().size()).isEqualTo(CAPACITY);
        return petHotel;
    }

}
