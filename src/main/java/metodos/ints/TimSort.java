
package metodos.ints;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TimSort {

    private final int RUN = 32;

    public void timSort(List<Integer> años) {
        int n = años.size();
        for (int i = 0; i < n; i += RUN) {
            insertionSort(años, i, Math.min((i + RUN - 1), (n - 1)));
        }

        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                if (mid < right) {
                    merge(años, left, mid, right);
                }
            }
        }
    }

    private void insertionSort(List<Integer> años, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = años.get(i);
            int j = i - 1;
            while (j >= left && años.get(j) > temp) {
                años.set(j + 1, años.get(j));
                j--;
            }
            años.set(j + 1, temp);
        }
    }

    private void merge(List<Integer> años, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        List<Integer> leftArr = new ArrayList<>(len1);
        List<Integer> rightArr = new ArrayList<>(len2);

        for (int i = 0; i < len1; i++) {
            leftArr.add(años.get(left + i));
        }
        for (int i = 0; i < len2; i++) {
            rightArr.add(años.get(mid + 1 + i));
        }

        int i = 0, j = 0, k = left;
        while (i < len1 && j < len2) {
            if (leftArr.get(i) <= rightArr.get(j)) {
                años.set(k, leftArr.get(i));
                i++;
            } else {
                años.set(k, rightArr.get(j));
                j++;
            }
            k++;
        }

        while (i < len1) {
            años.set(k, leftArr.get(i));
            i++;
            k++;
        }

        while (j < len2) {
            años.set(k, rightArr.get(j));
            j++;
            k++;
        }
    }
}
