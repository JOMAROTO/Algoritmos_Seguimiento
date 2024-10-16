package metodos.ints;

import java.util.List;
import java.util.Collections;

public class BitonicSort {
    public void bitonicSort(List<Integer> list, int low, int cnt, boolean dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            bitonicSort(list, low, k, true);
            bitonicSort(list, low + k, k, false);
            bitonicMerge(list, low, cnt, dir);
        }
    }

    private void bitonicMerge(List<Integer> list, int low, int cnt, boolean dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++) {
                if (dir == (list.get(i) > list.get(i + k))) {
                    Collections.swap(list, i, i + k);
                }
            }
            bitonicMerge(list, low, k, dir);
            bitonicMerge(list, low + k, k, dir);
        }
    }

    public void sort(List<Integer> list) {
        bitonicSort(list, 0, list.size(), true);
    }
}
