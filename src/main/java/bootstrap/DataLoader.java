package bootstrap;

import model.Theatre;
import util.Printer;
import util.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataLoader {

    Theatre theatre = new Theatre("Olympian", 8, 12);

    public void load() {
        /*
        // theatre.getSeats();

        if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Seat is already reserved!");
        }

        if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Seat is already reserved!");
        }

        System.out.println("---Without Built In Binary---");

        if (theatre.reserveSeatNoBinary("A11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Seat is already reserved!");
        }

        if (theatre.reserveSeatNoBinary("A11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Seat is already reserved!");
        }

        if (theatre.reserveSeatNoBinary("D12")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Seat is already reserved!");
        }

        if (theatre.reserveSeatNoBinary("B13")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Seat is already reserved!");
        }

        Printer.printSeparator();

        Printer.printList(theatre.seats);

        // shallow copy!
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);

        Printer.printList(seatCopy);

        seatCopy.get(1).reserve();
        String seatNumber = "A02";
        if (theatre.reserveSeatNoBinary(seatNumber)) {
            System.out.println("Please pay for " + seatNumber);
        } else {
            System.out.println("The seat is already taken!");
        }

        Collections.reverse(seatCopy);
        System.out.println("Print seatCopy");
        Printer.printList(seatCopy);
        System.out.println("Printing theatre.seat");
        Printer.printList(theatre.seats);

        Printer.printSeparator();

        // shuffle the items in random order!
        Collections.shuffle(seatCopy);
        Printer.printList(seatCopy);

        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSEAT_NUMBER());
        System.out.println("Max seat number is " + maxSeat.getSEAT_NUMBER());

        Printer.printSeparator();

        Sort.sortList(seatCopy);
        System.out.println("Print sorted seatCopy");
        Printer.printList(seatCopy);

        Collections.swap(seatCopy, 1, 2);
        System.out.println("Print swapped elements (index: 1 /element=2/ & index: 2 /element=3/)  seatCopy");
        Printer.printList(seatCopy);
        */

        /*
        // this one gives an error!
        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
        Collections.copy(newList, theatre.seats);
        */

        // refactor in Theatre class the arraylist from public to private! and change back Seat class to private (innerclass!)

        Theatre theatre = new Theatre("Olympian", 8, 12);

        String seat = "D12";
        if (theatre.reserveSeat(seat)) {
            System.out.println("Please pay for " + seat);
        } else {
            System.out.println("Seat already reserved!");
        }

        String seatWrong = "B13";

        if (theatre.reserveSeat(seatWrong)) {
            System.out.println("Please pay for " + seatWrong);
        } else {
            System.out.println("Seat already reserved!");
        }

        List<Theatre.Seat> reversedSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reversedSeats);
        Theatre.Seat.printList(reversedSeats);
    }
}
