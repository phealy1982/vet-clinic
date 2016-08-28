package serenitylabs.tutorials.vetclinic.collections.katas;

import org.assertj.core.data.MapEntry;
import org.junit.Before;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.BookingResponse;
import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.PetHotel;

import static org.assertj.core.api.Assertions.assertThat;


public class WhenBookingPetsIntoAPetHotel {

    private PetHotel aHotel;
    private Pet roverTheDog;
    private Pet fidoTheDog;
    private PetHotel petHotelWithTwentyPets;
    private static final Integer HOTEL_CAPACITY=20;


    @Before
    public void setUp() throws Exception {
        this.aHotel = new PetHotel();
        this.roverTheDog = new Pet("Rover", Breed.Dog);
        this.fidoTheDog = new Pet("Fido", Breed.Dog);

        this.petHotelWithTwentyPets = new PetHotel();

        for(int i=0; i<HOTEL_CAPACITY; i++){
            petHotelWithTwentyPets.checkIn(new Pet("Rover"+i,Breed.Dog));
        }
    }

    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {

        assertThat(aHotel.getPets()).isEmpty();
    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {

        aHotel.checkIn(roverTheDog);

        assertThat(aHotel.getPets()).containsValue(roverTheDog);
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {

        aHotel.checkIn(roverTheDog);
        aHotel.checkIn(fidoTheDog);

        assertThat(aHotel.getPets()).containsValues(roverTheDog, fidoTheDog);


    }

    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {

        Integer sizeBeforeCheckIns = aHotel.getPets().size();

        aHotel.checkIn(roverTheDog);
        aHotel.checkIn(roverTheDog);
        aHotel.checkIn(roverTheDog);
        aHotel.checkIn(roverTheDog);


        assertThat(aHotel.getPets()).hasSize(sizeBeforeCheckIns + 1);
    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {

        aHotel.checkIn(roverTheDog);
        aHotel.checkIn(fidoTheDog);


        assertThat(aHotel.getPets()).containsExactly(
            MapEntry.entry("Fido", fidoTheDog),
            MapEntry.entry("Rover", roverTheDog)
        );

    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {

        BookingResponse bookingResponse = aHotel.checkIn(roverTheDog);

        assertThat(bookingResponse).isNotNull();
        assertThat(bookingResponse.isConfirmed()).isTrue();
    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {

        Pet petToCheckIn = new Pet("NotRover", Breed.Fish);

        petHotelWithTwentyPets.checkIn(petToCheckIn);

        assertThat(petHotelWithTwentyPets.getPets().size()).isEqualTo(HOTEL_CAPACITY);
        assertThat(petHotelWithTwentyPets.getPets()).doesNotContainValue(petToCheckIn);
    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {

        Pet petToCheckIn = new Pet("NotRover", Breed.Fish);

        BookingResponse bookingResponse = petHotelWithTwentyPets.checkIn(petToCheckIn);

        assertThat(bookingResponse.isConfirmed()).isFalse();

    }


    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {

        Pet petToCheckIn = new Pet("NotRover", Breed.Fish);
        BookingResponse bookingResponse = petHotelWithTwentyPets.checkIn(petToCheckIn);

        assertThat(bookingResponse.isOnWaitingList()).isTrue();

    }

    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {

        Pet firstPetToTryCheckIn = new Pet("NotRover", Breed.Fish);
        Pet petToCheckOut = new Pet("Rover1", Breed.Dog);

        petHotelWithTwentyPets.checkIn(firstPetToTryCheckIn);

        petHotelWithTwentyPets.checkOut(petToCheckOut);

        assertThat(petHotelWithTwentyPets.getPets()).containsValue(firstPetToTryCheckIn);
    }


    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {

        Pet firstPetToTryCheckIn = new Pet("NotRover", Breed.Fish);
        Pet secondPetToTryCheckIn = new Pet("NotRoverEither", Breed.Fish);
        Pet petToCheckOut = new Pet("Rover1", Breed.Dog);

        petHotelWithTwentyPets.checkIn(firstPetToTryCheckIn);
        petHotelWithTwentyPets.checkIn(secondPetToTryCheckIn);

        petHotelWithTwentyPets.checkOut(petToCheckOut);

        assertThat(petHotelWithTwentyPets.getPets()).containsValue(firstPetToTryCheckIn);
    }

}
