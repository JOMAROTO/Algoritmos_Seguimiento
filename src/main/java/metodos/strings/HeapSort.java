package metodos.strings;

import java.util.List;

public class HeapSort {
    public void sort(List<String> titulos) {
        int n = titulos.size();

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(titulos, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            String temp = titulos.get(0);
            titulos.set(0, titulos.get(i));
            titulos.set(i, temp);

            // call max heapify on the reduced heap
            heapify(titulos, i, 0);
        }
    }

    private void heapify(List<String> titulos, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && titulos.get(left).compareTo(titulos.get(largest)) > 0) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && titulos.get(right).compareTo(titulos.get(largest)) > 0) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            String swap = titulos.get(i);
            titulos.set(i, titulos.get(largest));
            titulos.set(largest, swap);

            // Recursively heapify the affected sub-tree
            heapify(titulos, n, largest);
        }
    }
}
