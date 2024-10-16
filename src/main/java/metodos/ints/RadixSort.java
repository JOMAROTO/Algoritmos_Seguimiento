package metodos.ints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RadixSort {
    public void radixSort(List<Integer> años) {
        if (años == null || años.isEmpty()) {
            return;
        }

        final int RADIX = 10;
        List<List<Integer>> buckets = new ArrayList<>(RADIX);
        for (int i = 0; i < RADIX; i++) {
            buckets.add(new ArrayList<>());
        }

        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;
            for (Integer i : años) {
                tmp = i / placement;
                buckets.get(tmp % RADIX).add(i);
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }

            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : buckets.get(b)) {
                    años.set(a++, i);
                }
                buckets.get(b).clear();
            }

            placement *= RADIX;
        }
    }
}
