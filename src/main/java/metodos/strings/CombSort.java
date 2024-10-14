package metodos.strings;

import java.util.Collections;
import java.util.List;

public class CombSort {
    
    public void combSort(List<String> titulos) {
        int gap = titulos.size();
        boolean swapped = true;
        
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            
            for (int i = 0; i < titulos.size() - gap; i++) {
                if (titulos.get(i).compareTo(titulos.get(i + gap)) > 0) {
                    Collections.swap(titulos, i, i + gap);
                    swapped = true;
                }
            }
        }
    }

    private int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        if (gap < 1) {
            return 1;
        }
        return gap;
    }
}
