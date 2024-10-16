package metodos.strings;

import java.util.Collections;
import java.util.List;

public class BitonicSort {
    public void bitonicSort(List<String> titulos, boolean ascending) {
        if (titulos == null || titulos.size() <= 1) {
            return;
        }
        bitonicSortHelper(titulos, 0, titulos.size(), ascending);
    }

    private void bitonicSortHelper(List<String> titulos, int low, int count, boolean ascending) {
        if (count > 1) {
            int k = count / 2;
            bitonicSortHelper(titulos, low, k, true);
            bitonicSortHelper(titulos, low + k, count - k, false);
            bitonicMerge(titulos, low, count, ascending);
        }
    }

    private void bitonicMerge(List<String> titulos, int low, int count, boolean ascending) {
        if (count > 1) {
            int k = count / 2;
            for (int i = low; i < low + k; i++) {
                if ((titulos.get(i).compareTo(titulos.get(i + k)) > 0) == ascending) {
                    Collections.swap(titulos, i, i + k);
                }
            }
            bitonicMerge(titulos, low, k, ascending);
            bitonicMerge(titulos, low + k, k, ascending);
        }
    }
}
