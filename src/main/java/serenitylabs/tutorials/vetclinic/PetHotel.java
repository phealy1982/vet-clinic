package serenitylabs.tutorials.vetclinic;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by peterhealy on 27/08/2016.
 */
public class PetHotel {

    private static final Integer FIRST_ITEM = 0;
    private TreeMap<String, Pet> pets;
    private List<Pet> waitingList;

    public PetHotel(){
        this.pets = new TreeMap<>() ;
        this.waitingList = new ArrayList<>();
    }


    public TreeMap<String, Pet> getPets() {
        return pets;
    }

    public BookingResponse checkIn(Pet petToCheckIn) {

        if(pets.size()<20){
            this.pets.put(petToCheckIn.getName(),petToCheckIn);
            return new BookingResponse(Math.random(),petToCheckIn, true, false);
        } else {
            waitingList.add(petToCheckIn);
            return new BookingResponse(Math.random(), petToCheckIn, false, true);
        }


    }

    public void checkOut(Pet petToCheckOut) {

        pets.remove(petToCheckOut.getName());

        checkIn(waitingList.get(FIRST_ITEM));
        waitingList.remove(FIRST_ITEM);

    }

    //Comparator<Pet> byName = (Pet p1, Pet p2) -> p1.getName().compareTo(p2.getName());

}
