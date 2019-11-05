package com.lalit.algorithm.general.flightinfosort.main;

import java.util.Comparator;

public class DepartureLocationComparator implements Comparator<FlightInfo> {

    private String sortingOrder;

    public DepartureLocationComparator(String sortingOrder) {
        this.sortingOrder = sortingOrder;
    }

    @Override
    public int compare(FlightInfo o1, FlightInfo o2) {
        if (sortingOrder.equalsIgnoreCase("Asc"))
            return o1.getDeptLocation().compareTo(o2.getDeptLocation());
        else
            return o2.getDeptLocation().compareTo(o1.getDeptLocation());
    }

}
