package serenitylabs.tutorials.vetclinic.collections.katas;

import org.junit.Before;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Pet;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenBookingPetsIntoAPetHotel {


    private PetHotel newPetHotel;
    private static final Pet aDogNamedRover = Pet.dog().named("Rover");
    private static final Pet aDogNamedFido = Pet.dog().named("Fido");
    private PetHotel hotelAtCapacity;


    @Before public void setUp() throws Exception {
        newPetHotel = new PetHotel();
        hotelAtCapacity = new PetHotel();
        for(int i=0; i<PetHotel.HOTEL_CAPACITY; i++){
            BookingResponse response = hotelAtCapacity.checkIn(Pet.dog().named("RoverClone"+i));
            System.out.println(response.getBookingNumber());
        }

        assertThat(hotelAtCapacity.getPets().size()).isEqualTo(PetHotel.HOTEL_CAPACITY);
    }

    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {
        assertThat(newPetHotel.getPets()).isEmpty();
    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
        newPetHotel.checkIn(aDogNamedRover);
        assertThat(newPetHotel.getPets()).contains(aDogNamedRover);
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {

        newPetHotel.checkIn(aDogNamedRover);
        newPetHotel.checkIn(aDogNamedFido);

        assertThat(newPetHotel.getPets()).contains(aDogNamedRover);
        assertThat(newPetHotel.getPets()).contains(aDogNamedFido);
    }

    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {

        newPetHotel.checkIn(aDogNamedFido);
        newPetHotel.checkIn(aDogNamedFido);

        assertThat(newPetHotel.getPets()).containsOnlyOnce(aDogNamedFido);
    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {

        newPetHotel.checkIn(aDogNamedRover);
        newPetHotel.checkIn(aDogNamedFido);

        assertThat(newPetHotel.getPets()).containsSequence(aDogNamedFido, aDogNamedRover);
    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {

        BookingResponse bookingResponse = newPetHotel.checkIn(aDogNamedFido);

        assertThat(bookingResponse.isConfirmed()).isTrue();
        assertThat(bookingResponse.getPet()).isEqualTo(aDogNamedFido);
    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {

        hotelAtCapacity.checkIn(aDogNamedFido);

        assertThat(hotelAtCapacity.getPets().size()).isEqualTo(PetHotel.HOTEL_CAPACITY);
    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {

        BookingResponse bookingResponse = hotelAtCapacity.checkIn(aDogNamedFido);

        assertThat(bookingResponse.isConfirmed()).isFalse();
        assertThat(bookingResponse.isOnWaitingList()).isTrue();
    }


    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {

        hotelAtCapacity.checkIn(aDogNamedFido);

        assertThat(hotelAtCapacity.getPetsOnWaitingList()).contains(aDogNamedFido);
    }

    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {

        hotelAtCapacity.checkIn(aDogNamedFido);

        hotelAtCapacity.checkOut("RoverClone1");

        assertThat(hotelAtCapacity.getPets()).contains(aDogNamedFido);

    }


    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {

        hotelAtCapacity.checkIn(aDogNamedFido);
        hotelAtCapacity.checkIn(aDogNamedRover);

        hotelAtCapacity.checkOut("RoverClone2");

        assertThat(hotelAtCapacity.getPets()).contains(aDogNamedFido);

    }

    @Test
    public void should_create_unique_booking_number() throws Exception {

        BookingResponse fidoResponse = newPetHotel.checkIn(Pet.dog().named("Fido"));
        BookingResponse roverResponse = newPetHotel.checkIn(Pet.dog().named("Rover"));

        assertThat(fidoResponse.getBookingNumber()).isNotEqualTo(roverResponse.getBookingNumber());


    }

    @Test
    public void should_booking_number_should_remain_the_same() throws Exception {

        BookingResponse fidoResponse = newPetHotel.checkIn(Pet.dog().named("Fido"));

        assertThat(fidoResponse.getBookingNumber()).isEqualTo(fidoResponse.getBookingNumber());

    }

    @Test
    public void should_return_on_waiting_list_false_when_booking_successful() throws Exception {

        BookingResponse fidoResponse = newPetHotel.checkIn(Pet.dog().named("Fido"));

        assertThat(fidoResponse.isOnWaitingList()).isFalse();

    }
}
