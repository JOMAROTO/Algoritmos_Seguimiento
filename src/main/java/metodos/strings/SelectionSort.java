package metodos.strings;

import java.util.List;

public class SelectionSort {
    public void selectionSort(List<String> titulos) {
        int n = titulos.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (titulos.get(j).compareTo(titulos.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            String temp = titulos.get(minIndex);
            titulos.set(minIndex, titulos.get(i));
            titulos.set(i, temp);
        }
    }
}
