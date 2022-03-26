package util;

import model.Theatre;

import java.util.List;

public class Printer {

    public static void printList(List<Theatre.Seat> seats) {
        for (Theatre.Seat seat : seats) {
            System.out.print(" " + seat.getSEAT_NUMBER());
        }
        System.out.println();
        System.out.println("===============================================================");
    }

    public static void printSeparator() {
        System.out.println("-----------------------------------------");
    }
}
