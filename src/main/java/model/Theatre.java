package model;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private final String THEATRE_NAME;
    private List<Seat> seats = new ArrayList<>();

    public Theatre(String THEATRE_NAME, int numRows, int seatsPerRow) {
        this.THEATRE_NAME = THEATRE_NAME;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <=

                lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = null;
        for (Seat seat : seats) {
            if (seat.getSEAT_NUMBER().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }

        if (requestedSeat == null) {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
        return requestedSeat.reserve();
    }

    // for testing
    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSEAT_NUMBER());
        }
    }

    public String getTHEATRE_NAME() {
        return THEATRE_NAME;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    private class Seat {
        private final String SEAT_NUMBER;
        private boolean reserved = false;

        public Seat(String SEAT_NUMBER) {
            this.SEAT_NUMBER = SEAT_NUMBER;
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + SEAT_NUMBER + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("The reservation of seat " + SEAT_NUMBER + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSEAT_NUMBER() {
            return SEAT_NUMBER;
        }

        public boolean isReserved() {
            return reserved;
        }

        public void setReserved(boolean reserved) {
            this.reserved = reserved;
        }
    }
}
