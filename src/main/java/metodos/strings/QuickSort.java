package metodos.strings;

import java.util.List;

public class QuickSort {
    public void quickSort(List<String> titulos, int low, int high) {
        if (low < high) {
            int pi = partition(titulos, low, high);
            quickSort(titulos, low, pi - 1);
            quickSort(titulos, pi + 1, high);
        }
    }

    private int partition(List<String> titulos, int low, int high) {
        String pivot = titulos.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (titulos.get(j).compareTo(pivot) <= 0) {
                i++;
                String temp = titulos.get(i);
                titulos.set(i, titulos.get(j));
                titulos.set(j, temp);
            }
        }
        String temp = titulos.get(i + 1);
        titulos.set(i + 1, titulos.get(high));
        titulos.set(high, temp);
        return i + 1;
    }
}
