package metodos.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PigeonholeSort {
    public void pigeonholeSort(List<String> titulos) {
        if (titulos == null || titulos.isEmpty()) {
            return;
        }

        // Find the range of the strings
        String min = Collections.min(titulos);
        String max = Collections.max(titulos);
        int range = max.compareTo(min) + 1;

        // Create pigeonholes
        List<List<String>> pigeonholes = new ArrayList<>(range);
        for (int i = 0; i < range; i++) {
            pigeonholes.add(new ArrayList<>());
        }

        // Place strings in their respective pigeonholes
        for (String titulo : titulos) {
            int index = titulo.compareTo(min);
            pigeonholes.get(index).add(titulo);
        }

        // Collect the sorted strings
        int index = 0;
        for (List<String> hole : pigeonholes) {
            for (String titulo : hole) {
                titulos.set(index++, titulo);
            }
        }
    }
}
