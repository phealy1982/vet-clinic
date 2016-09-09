package serenitylabs.tutorials.vetclinic.collections.katas;

import org.junit.Before;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Pet;


import static org.assertj.core.api.Assertions.assertThat;

public class WhenBookingPetsIntoAPetHotel {


    private PetHotel hotelAtCapacity;

    @Before public void setUp() throws Exception {
        hotelAtCapacity = new PetHotel();
        for(int i=0;i < PetHotel.HOTEL_CAPACITY; i++){
            hotelAtCapacity.checkIn(new Pet("RoverClone"+i, Breed.Dog));
        }

    }

    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {
        PetHotel petHotel = new PetHotel();

        assertThat(petHotel.getPets()).isEmpty();
    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
        PetHotel petHotel = new PetHotel();

        petHotel.checkIn(Pet.dog().named("Fido"));

        assertThat(petHotel.getPets().values()).contains(Pet.dog().named("Fido"));
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {
        PetHotel petHotel = new PetHotel();

        petHotel.checkIn(Pet.dog().named("Fido"));
        petHotel.checkIn(Pet.dog().named("Rover"));

        assertThat(petHotel.getPets().values()).contains(Pet.dog().named("Fido"), Pet.dog().named("Rover"));
    }

    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {
        PetHotel petHotel = new PetHotel();

        petHotel.checkIn(Pet.dog().named("Fido"));
        petHotel.checkIn(Pet.dog().named("Fido"));

        assertThat(petHotel.getPets().size()).isEqualTo(1);

    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {
        PetHotel petHotel = new PetHotel();

        petHotel.checkIn(Pet.dog().named("Xavier"));
        petHotel.checkIn(Pet.dog().named("Fido"));
        petHotel.checkIn(Pet.dog().named("Rover"));

        assertThat(petHotel.getPetsInAlphabethicalOrder()).containsExactly(
                Pet.dog().named("Fido"),
                Pet.dog().named("Rover"),
                Pet.dog().named("Xavier")
                );

    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {
        PetHotel petHotel = new PetHotel();

        Pet xavier = Pet.dog().named("Xavier");

        Booking bookingResponse = petHotel.checkIn(xavier);

        assertThat(bookingResponse.getPet()).isEqualTo(xavier);
        assertThat(bookingResponse.getBookingNumber()).isNotNull();
        assertThat(bookingResponse.isConfirmed()).isTrue();


    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {

        assertThat(hotelAtCapacity.getPets().size()).isEqualTo(PetHotel.HOTEL_CAPACITY);

        Booking bookingResponse =hotelAtCapacity.checkIn(Pet.dog().named("Fido"));

        assertThat(hotelAtCapacity.getPets().size()).isEqualTo(PetHotel.HOTEL_CAPACITY);
        assertThat(bookingResponse.isConfirmed()).isFalse();

    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {

        assertThat(hotelAtCapacity.getPets().size()).isEqualTo(PetHotel.HOTEL_CAPACITY);

        Booking bookingResponse =hotelAtCapacity.checkIn(Pet.dog().named("Fido"));

        assertThat(bookingResponse.isConfirmed()).isFalse();

    }


    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {

        assertThat(hotelAtCapacity.getPets().size()).isEqualTo(PetHotel.HOTEL_CAPACITY);

        Booking bookingResponse =hotelAtCapacity.checkIn(Pet.dog().named("Fido"));

        assertThat(bookingResponse.isOnWaitingList()).isTrue();
    }

    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {

        assertThat(hotelAtCapacity.getPets().size()).isEqualTo(PetHotel.HOTEL_CAPACITY);

        hotelAtCapacity.checkIn(Pet.dog().named("Fido"));

        hotelAtCapacity.checkout("RoverClone1");

        assertThat(hotelAtCapacity.getPetsInAlphabethicalOrder()).contains(Pet.dog().named("Fido"));

    }


    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {

        assertThat(hotelAtCapacity.getPets().size()).isEqualTo(PetHotel.HOTEL_CAPACITY);

        hotelAtCapacity.checkIn(Pet.dog().named("Fido"));
        hotelAtCapacity.checkIn(Pet.dog().named("Spot"));

        hotelAtCapacity.checkout("RoverClone1");

        assertThat(hotelAtCapacity.getPetsInAlphabethicalOrder()).contains(Pet.dog().named("Fido"));
        assertThat(hotelAtCapacity.getPetsInAlphabethicalOrder()).doesNotContain(Pet.dog().named("Spot"));

    }

    @Test
    public void should_take_two_pets_from_waiting_list() throws Exception {

        hotelAtCapacity.checkIn(Pet.dog().named("Fido"));
        hotelAtCapacity.checkIn(Pet.dog().named("Spot"));

        hotelAtCapacity.checkout("RoverClone1");
        hotelAtCapacity.checkout("RoverClone2");

        assertThat(hotelAtCapacity.getPetsInAlphabethicalOrder()).contains(Pet.dog().named("Fido"));
        assertThat(hotelAtCapacity.getPetsInAlphabethicalOrder()).contains(Pet.dog().named("Spot"));

    }
}
