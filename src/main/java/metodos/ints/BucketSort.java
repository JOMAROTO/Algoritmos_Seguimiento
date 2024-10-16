package metodos.ints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public void bucketSort(List<Integer> años) {
        if (años == null || años.size() == 0) {
            return;
        }

        // Find the maximum value to determine the range of the buckets
        int max = Collections.max(años);
        int min = Collections.min(años);

        // Number of buckets
        int bucketCount = (max - min) / años.size() + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);

        // Initialize buckets
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute input list values into buckets
        for (int num : años) {
            int bucketIndex = (num - min) / años.size();
            buckets.get(bucketIndex).add(num);
        }

        // Sort each bucket and collect the results
        años.clear();
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            años.addAll(bucket);
        }
    }
}
