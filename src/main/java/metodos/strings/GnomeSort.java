package metodos.strings;

import java.util.Collections;
import java.util.List;

public class GnomeSort {
    public void gnomeSort(List<String> titulos) {
        int index = 0;
        while (index < titulos.size()) {
            if (index == 0 || titulos.get(index).compareTo(titulos.get(index - 1)) >= 0) {
                index++;
            } else {
                Collections.swap(titulos, index, index - 1);
                index--;
            }
        }
    }
}
