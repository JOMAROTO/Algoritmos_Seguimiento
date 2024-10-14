package metodos.strings;

import java.util.ArrayList;
import java.util.List;

public class TimSort{


public void timSort(List<String> titulos) {
    int n = titulos.size();
    int RUN = 32;

    for (int i = 0; i < n; i += RUN) {
        insertionSort(titulos, i, Math.min((i + 31), (n - 1)));
    }

    for (int size = RUN; size < n; size = 2 * size) {
        for (int left = 0; left < n; left += 2 * size) {
            int mid = left + size - 1;
            int right = Math.min((left + 2 * size - 1), (n - 1));

            if (mid < right) {
                merge(titulos, left, mid, right);
            }
        }
    }
}

private void insertionSort(List<String> titulos, int left, int right) {
    for (int i = left + 1; i <= right; i++) {
        String temp = titulos.get(i);
        int j = i - 1;
        while (j >= left && titulos.get(j).compareTo(temp) > 0) {
            titulos.set(j + 1, titulos.get(j));
            j--;
        }
        titulos.set(j + 1, temp);
    }
}

private void merge(List<String> titulos, int left, int mid, int right) {
    int len1 = mid - left + 1, len2 = right - mid;
    List<String> leftArr = new ArrayList<>(len1);
    List<String> rightArr = new ArrayList<>(len2);

    for (int i = 0; i < len1; i++) {
        leftArr.add(titulos.get(left + i));
    }
    for (int i = 0; i < len2; i++) {
        rightArr.add(titulos.get(mid + 1 + i));
    }

    int i = 0, j = 0, k = left;

    while (i < len1 && j < len2) {
        if (leftArr.get(i).compareTo(rightArr.get(j)) <= 0) {
            titulos.set(k, leftArr.get(i));
            i++;
        } else {
            titulos.set(k, rightArr.get(j));
            j++;
        }
        k++;
    }

    while (i < len1) {
        titulos.set(k, leftArr.get(i));
        i++;
        k++;
    }

    while (j < len2) {
        titulos.set(k, rightArr.get(j));
        j++;
        k++;
    }
}
}

