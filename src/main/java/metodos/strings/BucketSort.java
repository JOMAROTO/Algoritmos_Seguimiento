package metodos.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BucketSort {
    public void bucketSort(List<String> titulos) {
        // Create a map to hold buckets
        Map<Character, List<String>> buckets = new HashMap<>();

        // Distribute the strings into buckets based on the first character
        for (String s : titulos) {
            if (s.isEmpty())
                continue; // Skip empty strings
            char firstChar = s.charAt(0);
            buckets.computeIfAbsent(firstChar, k -> new ArrayList<>()).add(s);
        }

        // Sort each bucket and collect the results
        List<String> sortedList = new ArrayList<>();
        for (Map.Entry<Character, List<String>> entry : buckets.entrySet()) {
            List<String> bucket = entry.getValue();
            bucket.sort(null); // Sort the bucket
            sortedList.addAll(bucket);
        }

        // Replace the original list with the sorted list
        titulos.clear();
        titulos.addAll(sortedList);
    }
}
