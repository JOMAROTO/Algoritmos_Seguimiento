package metodos.strings;

import java.util.List;
import java.util.Collections;

public class BinaryInsertionSort {
    public void binaryInsertionSort(List<String> titulos) {
        for (int i = 1; i < titulos.size(); i++) {
            String key = titulos.get(i);
            int insertedPosition = Math.abs(Collections.binarySearch(titulos.subList(0, i), key) + 1);
            titulos.add(insertedPosition, titulos.remove(i));
        }
    }
}
