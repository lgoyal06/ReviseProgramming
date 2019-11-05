package com.lalit.algorithm.general.flightinfosort.main;

import java.util.Comparator;

public class FlightInfoComparatorFactory {

    private FlightInfoComparatorFactory() {
    }

    public static Comparator<FlightInfo> getComparator(String sortByField, String orderBy) throws ClassNotFoundException {
        switch (sortByField) {
            case "flightDate":
                return new FlightDateComparator(orderBy);
            case "departureLoc":
                return new DepartureLocationComparator(orderBy);
            case "arrivalLoc":
                return new ArrivalLocationComparator(orderBy);
            default:
                return null;
        }
    }
}
