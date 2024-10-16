package metodos.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadixSort {
    public void radixSort(List<String> titulos) {
        if (titulos == null || titulos.isEmpty()) {
            return;
        }

        int maxLength = 0;
        for (String titulo : titulos) {
            maxLength = Math.max(maxLength, titulo.length());
        }

        for (int pos = maxLength - 1; pos >= 0; pos--) {
            Map<Integer, List<String>> buckets = new HashMap<>();

            for (String titulo : titulos) {
                int charIndex = pos < titulo.length() ? titulo.charAt(pos) : 0;
                buckets.computeIfAbsent(charIndex, k -> new ArrayList<>()).add(titulo);
            }

            titulos.clear();
            for (List<String> bucket : buckets.values()) {
                titulos.addAll(bucket);
            }
        }
    }
}
