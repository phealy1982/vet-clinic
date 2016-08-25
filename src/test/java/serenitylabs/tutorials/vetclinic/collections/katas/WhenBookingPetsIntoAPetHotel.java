package serenitylabs.tutorials.vetclinic.collections.katas;

import org.junit.Before;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Pet;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class WhenBookingPetsIntoAPetHotel {

    PetHotel hotelWithTwentyPets;

    @Before
    public void setUp() throws Exception {

        hotelWithTwentyPets = new PetHotel();

        for(int i=0; i<20;i++){
            hotelWithTwentyPets.checkIn(new Pet("name"+i,Breed.Dog));
        }

    }

    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {
        PetHotel pethotel = new PetHotel();
        assertThat(pethotel.getPets()).isNull();
    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
        PetHotel petHotel = new PetHotel();
        Pet petToCheckIn = new Pet("Rover", Breed.Dog);
        petHotel.checkIn(petToCheckIn);

        assertThat(petToCheckIn).isIn(petHotel.getPets());
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {
        PetHotel petHotel = new PetHotel();
        Pet rover = new Pet("Rover", Breed.Dog);
        Pet fido = new Pet("Fido", Breed.Dog);

        petHotel.checkIn(rover);
        petHotel.checkIn(fido);

        assertThat(fido).isIn(petHotel.getPets());
        assertThat(rover).isIn(petHotel.getPets());

    }

    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {
        PetHotel petHotel = new PetHotel();
        Pet rover = new Pet("Rover", Breed.Dog);

        petHotel.checkIn(rover);

        Integer numberOfPets = petHotel.getPets().size();

        petHotel.checkIn(rover);

        assertThat(petHotel.getPets().size()).isLessThanOrEqualTo(numberOfPets);


    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {


    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {

        PetHotel petHotel = new PetHotel();
        Pet rover = new Pet("Rover", Breed.Dog);

        BookingResponse bookingResponse = petHotel.checkIn(rover);

        assertThat(bookingResponse.getPet()).isEqualTo(rover);
        assertThat(bookingResponse.getBookingNumber()).isNotEmpty();
        assertThat(bookingResponse.isConfirmed()).isTrue();

    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {

        hotelWithTwentyPets.checkIn(new Pet("fido", Breed.Dog));

        assertThat(hotelWithTwentyPets.getPets().size()).isEqualTo(20);

    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {

    }


    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {
    }

    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {
    }


    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {
    }

}
