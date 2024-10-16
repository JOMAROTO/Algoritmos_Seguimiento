package metodos.ints;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PigeonholeSort {
    public void pigeonholeSort(List<Integer> años) {
        if (años.isEmpty()) {
            return;
        }

        int min = Collections.min(años);
        int max = Collections.max(años);
        int range = max - min + 1;

        List<Integer> holes = new ArrayList<>(Collections.nCopies(range, 0));

        for (int año : años) {
            holes.set(año - min, holes.get(año - min) + 1);
        }

        int index = 0;
        for (int i = 0; i < range; i++) {
            while (holes.get(i) > 0) {
                años.set(index++, i + min);
                holes.set(i, holes.get(i) - 1);
            }
        }
    }
}
