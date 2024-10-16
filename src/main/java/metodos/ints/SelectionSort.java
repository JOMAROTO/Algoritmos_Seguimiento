package metodos.ints;

import java.util.List;

public class SelectionSort {
    public void selectionSort(List<Integer> años) {
        for (int i = 0; i < años.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < años.size(); j++) {
                if (años.get(j) < años.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = años.get(minIndex);
            años.set(minIndex, años.get(i));
            años.set(i, temp);
        }
    }
}
