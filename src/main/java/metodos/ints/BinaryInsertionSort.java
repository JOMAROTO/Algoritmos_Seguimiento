package metodos.ints;

import java.util.List;
import java.util.Collections;

public class BinaryInsertionSort {
    public void binaryInsertionSort(List<Integer> años) {
        for (int i = 1; i < años.size(); i++) {
            int key = años.get(i);
            int insertedPosition = binarySearch(años, key, 0, i - 1);
            años.add(insertedPosition, key);
            años.remove(i + 1);
        }
    }

    private int binarySearch(List<Integer> años, int key, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (años.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
