package metodos.ints;

import java.util.List;

public class GnomeSort {
    public void sort(List<Integer> list) {
        int index = 0;
        while (index < list.size()) {
            if (index == 0 || list.get(index) >= list.get(index - 1)) {
                index++;
            } else {
                int temp = list.get(index);
                list.set(index, list.get(index - 1));
                list.set(index - 1, temp);
                index--;
            }
        }
    }
}
