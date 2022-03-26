package model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Theatre {

    private final String THEATRE_NAME;
    // private List<Seat> seats = new ArrayList<>();
    // we can change ArrayList to LinkedList ... as it is declared using List interface!
    // private List<Seat> seats = new LinkedList<>();
    // if we change it to Collection ... more generic!
    // private Collection<Seat> seats = new ArrayList<>();
    // private Collection<Seat> seats = new HashSet<>(); // <- using different order in case of set! BUT works!
    //private Collection<Seat> seats = new LinkedHashSet<>(); // <- returns in order this time!
    // private Collection<Seat> seats = new TreeSet<>(); // <- gives error: ClassCastException
    private List<Seat> seats = new ArrayList<>();

    public static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if (seat1.getPrice() < seat2.getPrice()) {
                return -1;
            } else if (seat1.getPrice() > seat2.getPrice()) {
                return 1;
            } else {
                return 0;
            }
        }
    };

    public Theatre(String THEATRE_NAME, int numRows, int seatsPerRow) {
        this.THEATRE_NAME = THEATRE_NAME;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <=

                lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;
                if (row < 'D' &&seatNum >= 4 && seatNum <= 9) {
                    price = 14.00;
                } else if (row > 'F' || seatNum < 4 || seatNum > 9); {
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);

        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

//        for (Seat seat : seats) {
//            System.out.print(".");
//            if (seat.getSEAT_NUMBER().equals(seatNumber)) {
//                requestedSeat = seat;
//                break;
//            }
//        }
//
//        if (requestedSeat == null) {
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//        return requestedSeat.reserve();
    }

    public boolean reserveSeatNoBinary(String seatNumber) {
        // Sorted list!!! -> if needed: Collections.sort(list); <- this one much better than the bubble sort
        // reversed array: Arrays.sort(Collections.reverseOrder(array, Collections.reverseOrder());
        // reversed list: Collections.sort(arrayList, Collections.reverseOrder());
        int low = 0;
        int high = seats.size() - 1;

        while (low <= high) {
            System.out.print(".");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSEAT_NUMBER().compareTo(seatNumber);

            if (cmp < 0 ) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("There is no seat " + seatNumber);
        return false;
    }


    // for testing
    /*public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSEAT_NUMBER());
        }
    }*/

    public Collection<Seat> getSeats() {
        return seats;
    }

    public String getTHEATRE_NAME() {
        return THEATRE_NAME;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public class Seat implements Comparable<Seat> {
        private final String SEAT_NUMBER;
        private boolean reserved = false;
        private double price;
        private static final DecimalFormat PRICE_OF_SEAT = new DecimalFormat("0.00");


        public Seat(String SEAT_NUMBER, double price) {
            this.SEAT_NUMBER = SEAT_NUMBER;
            this.price = price;
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

        @Override
        public int compareTo(Seat seat) {
            return this.SEAT_NUMBER.compareTo(seat.getSEAT_NUMBER());
        }

        public static void printList(List<Seat> seats) {
            for (Theatre.Seat seat : seats) {
                System.out.print(" " + seat.getSEAT_NUMBER() + " prices $" + PRICE_OF_SEAT.format(seat.getPrice()));
            }
            System.out.println();
            System.out.println("===============================================================");
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

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
