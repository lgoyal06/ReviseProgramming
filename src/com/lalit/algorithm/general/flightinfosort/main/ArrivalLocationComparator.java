package com.lalit.algorithm.general.flightinfosort.main;

import java.util.Comparator;

public class ArrivalLocationComparator implements Comparator<FlightInfo> {

    private String sortingOrder;

    public ArrivalLocationComparator(String sortingOrder) {
        this.sortingOrder = sortingOrder;
    }

    @Override
    public int compare(FlightInfo o1, FlightInfo o2) {
        if (sortingOrder.equalsIgnoreCase("Asc"))
            return o1.getArrivalLocation().compareTo(o2.getArrivalLocation());
        else
            return o2.getArrivalLocation().compareTo(o1.getArrivalLocation());
    }

}
