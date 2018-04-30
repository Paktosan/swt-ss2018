package de.paktosan.university.swt.taxi;

import java.util.ArrayList;
import java.util.Iterator;

public class Taxi {

    private Human driver;
    private ArrayList<Human> passengers;

    public Taxi(Human driver) {
        this.driver = driver;
        passengers = new ArrayList<>();
    }

    public String getDriverName() {
        return driver.toString();
    }

    public void add(Human passenger) {
        if (passengers.size() < 4) {
            passengers.add(passenger);
            System.out.println(String.format("%s gets in.", passenger.toString()));
        } else {
            System.out.println(String.format("We are sorry, %s. The taxi is full.", passenger.toString()));
        }
    }

    public Human[] allGetOut(){
        Human[] formerPassengers = passengers.toArray(new Human[0]);
        passengers.clear();
        return formerPassengers;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (passengers.size() == 0 ){
            builder.append("nobody");
        }else {
            Iterator<Human> passengerIterator = passengers.iterator();
            builder.append(passengerIterator.next());
            while (passengerIterator.hasNext()){
                Human iteratedPassenger = passengerIterator.next();
                if (!passengerIterator.hasNext()){
                    builder.append(" and ").append(iteratedPassenger);
                }else {
                    builder.append(", ").append(iteratedPassenger);
                }
            }
        }
        return String.format("This is the taxi of %s. He takes %s along.", getDriverName(), builder.toString());
    }
}
