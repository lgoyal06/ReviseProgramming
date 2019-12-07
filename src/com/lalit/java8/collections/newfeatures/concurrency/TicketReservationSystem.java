package com.lalit.java8.collections.newfeatures.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

class ReservationTask implements Callable {
    Dao dao;
    String trainName;
    int ticketCount;

    public ReservationTask(Dao dao, String trainName, int ticketCount) {
        this.dao = dao;
        this.ticketCount = ticketCount;
        this.trainName = trainName;
    }

    public Boolean call() throws InterruptedException {
        synchronized (dao) {
            System.out.println("Available Seats for " + trainName + " is " + dao.getNumberOfAvailableTickets(trainName));
            Thread.sleep(1000);
            boolean isTicketBooked = dao.reserveTicket(trainName, ticketCount);
            System.out.println("After booking Available Seats for " + trainName + " is " + dao.getNumberOfAvailableTickets(trainName));
            return isTicketBooked;
        }
    }
}

class Dao {

    private Map<String, Integer> trainInfo = new HashMap<String, Integer>();
    private static Dao daoObj = new Dao();

    private Dao() {
        trainInfo.put("a", 100);
        trainInfo.put("b", 100);
    }

    public static Dao getDaoObj() {
        return daoObj;
    }

    public Integer getNumberOfAvailableTickets(String trainName) {
        return trainInfo.get(trainName);
    }

    public boolean reserveTicket(String trainName, int ticketCount) {
        int remainingTickets = trainInfo.get(trainName) - ticketCount;
        if (remainingTickets >= 0) {
            trainInfo.put(trainName, remainingTickets);
            return true;
        }
        return false;
    }

}

public class TicketReservationSystem {

    ExecutorService executorService = Executors.newFixedThreadPool(4);

    public TicketReservationSystem() {
    }

    public Future<Boolean> reserveTicket(String trainName, int ticketCount) {
        // show problem and define a solution
        Dao dao = Dao.getDaoObj();
        ReservationTask rt = new ReservationTask(dao, trainName, ticketCount);
        return executorService.submit(rt);
    }

    public static void main(String... s) throws ExecutionException, InterruptedException {
        TicketReservationSystem trs = new TicketReservationSystem();
        Future<Boolean> resA = trs.reserveTicket("a", 10);
        Future<Boolean> resB = trs.reserveTicket("a", 90);
        Future<Boolean> resC = trs.reserveTicket("a", 90);
        Future<Boolean> resD = trs.reserveTicket("b", 100);
        System.out.println(resA.get());
        System.out.println(resB.get());
        System.out.println(resC.get());
        System.out.println(resD.get());
    }
}
