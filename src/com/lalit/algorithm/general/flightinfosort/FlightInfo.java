package com.lalit.algorithm.general.flightinfosort;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class FlightInfo {

    private String flightNumber;
    private String deptLocation;
    private String arrivalLocation;
    private double flightDuration;
    private BigDecimal fare;
    private LocalDate date;
    private LocalTime time;
    private LocalDateTime dateTime;

    public FlightInfo(FlightInfoBuilder flightInfoBuilder) {
        this.flightNumber = flightInfoBuilder.flightNumber;
        this.deptLocation = flightInfoBuilder.deptLocation;
        this.arrivalLocation = flightInfoBuilder.arrivalLocation;
        this.flightDuration = flightInfoBuilder.flightDuration;
        this.fare = flightInfoBuilder.fare;
        this.date = flightInfoBuilder.date;
        this.time = flightInfoBuilder.time;
    }


    public static class FlightInfoBuilder {

        private String flightNumber;
        private String deptLocation;
        private String arrivalLocation;
        private double flightDuration;
        private BigDecimal fare;
        private LocalDate date;
        private LocalTime time;
        private LocalDateTime dateTime;

        public FlightInfoBuilder setFlightNumber(String flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public FlightInfoBuilder setDeptLocation(String deptLocation) {
            this.deptLocation = deptLocation;
            return this;
        }

        public FlightInfoBuilder setArrivalLocation(String arrivalLocation) {
            this.arrivalLocation = arrivalLocation;
            return this;
        }

        public FlightInfoBuilder setFlightDuration(double flightDuration) {
            this.flightDuration = flightDuration;
            return this;
        }

        public FlightInfoBuilder setFare(BigDecimal fare) {
            this.fare = fare;
            return this;
        }

        public FlightInfoBuilder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public FlightInfoBuilder setTime(LocalTime time) {
            this.time = time;
            return this;
        }

        public static FlightInfoBuilder createInstance() {
            return new FlightInfoBuilder();
        }

        public FlightInfo build() {
            return new FlightInfo(this);
        }

    }
}
