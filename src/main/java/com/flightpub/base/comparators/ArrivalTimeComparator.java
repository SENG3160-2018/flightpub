package com.flightpub.base.comparators;

import com.flightpub.base.model.Flights;

import java.sql.Timestamp;
import java.util.Comparator;

public class ArrivalTimeComparator implements Comparator<Flights> {

    public int compare(Flights f1, Flights f2) {

        Timestamp arrivalTime1 = f1.getArrivalTime();
        Timestamp arrivalTime2 = f2.getArrivalTime();

        return arrivalTime1.compareTo(arrivalTime2);

    }

}
