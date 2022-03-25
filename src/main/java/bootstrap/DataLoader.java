package bootstrap;

import model.Theatre;

public class DataLoader {

    Theatre theatre = new Theatre("Olympian", 8, 12);

    public void load() {
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
    }
}
