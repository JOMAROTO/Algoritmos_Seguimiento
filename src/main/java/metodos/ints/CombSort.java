package metodos.ints;

import java.util.List;

public class CombSort {
    public void combSort(List<Integer> años) {
        int gap = años.size();
        boolean swapped = true;

        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.3);
            }

            swapped = false;

            for (int i = 0; i + gap < años.size(); i++) {
                if (años.get(i) > años.get(i + gap)) {
                    int temp = años.get(i);
                    años.set(i, años.get(i + gap));
                    años.set(i + gap, temp);
                    swapped = true;
                }
            }
        }
    }
}
