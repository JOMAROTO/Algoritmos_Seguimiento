package metodos.strings;

import java.util.ArrayList;
import java.util.List;

public class PigeonholeSort {
    public void pigeonholeSort(List<String> titulos) {
        if (titulos == null || titulos.isEmpty()) {
            return;
        }

        // Initialize min and max with the first element
        String min = titulos.get(0);
        String max = titulos.get(0);

        // Find the range of the strings using a for-each loop
        for (String titulo : titulos) {
            if (titulo.compareTo(min) < 0) {
                min = titulo;
            }
            if (titulo.compareTo(max) > 0) {
                max = titulo;
            }
        }

        int range = max.compareTo(min) + 1;

        // Create pigeonholes
        List<List<String>> pigeonholes = new ArrayList<>(range);
        for (int i = 0; i < range; i++) {
            pigeonholes.add(new ArrayList<>());
        }

        // Place strings in their respective pigeonholes
        for (String titulo : titulos) {
            int index = titulo.compareTo(min);
            if (index >= 0 && index < range) {
                pigeonholes.get(index).add(titulo);
            } else {
                throw new IndexOutOfBoundsException("Index " + index + " out of bounds for range " + range);
            }
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
