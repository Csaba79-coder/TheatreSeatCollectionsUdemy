package util;

import model.Theatre;

import java.util.Collections;
import java.util.List;

public class Sort {

    // much slower than built in merge sort! BUT this could be useful in situations where e.g.,
    // speed was not so important! BUT memory was at a premium!!!

    // after refactor Seat to private, not operates!

    /*public static void sortList(List<? extends Theatre.Seat> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0 ) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }*/
}
