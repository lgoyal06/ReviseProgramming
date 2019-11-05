package com.lalit.algorithm.general.flightinfosort.main;

import java.util.Comparator;

public class FlightDateComparator implements Comparator<FlightInfo> {

    private String sortingOrder;

    public FlightDateComparator(String sortingOrder) {
        this.sortingOrder = sortingOrder;
    }

    @Override
    public int compare(FlightInfo o1, FlightInfo o2) {
        if (sortingOrder.equalsIgnoreCase("Asc")) {
            return compares(o1, o2);
        } else {
            return compares(o2, o1);
        }
    }

    private int compares(FlightInfo o1, FlightInfo o2) {
        if (o1.getDate().isAfter(o2.getDate())) {
            return 1;
        } else if (o1.getDate().isBefore(o2.getDate())) {
            return -1;
        } else {
            if (o1.getTime().isAfter(o2.getTime())) {
                return 1;
            } else if (o1.getTime().isBefore(o2.getTime())) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
