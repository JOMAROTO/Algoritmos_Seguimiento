package metodos.ints;

import java.util.List;

public class HeapSort {
    public void sort(List<Integer> años) {
        int n = años.size();

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(años, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = años.get(0);
            años.set(0, años.get(i));
            años.set(i, temp);

            // call max heapify on the reduced heap
            heapify(años, i, 0);
        }
    }

    void heapify(List<Integer> años, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && años.get(left) > años.get(largest)) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && años.get(right) > años.get(largest)) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = años.get(i);
            años.set(i, años.get(largest));
            años.set(largest, swap);

            // Recursively heapify the affected sub-tree
            heapify(años, n, largest);
        }
    }
}
