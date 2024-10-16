package metodos.ints;

import java.util.ArrayList;
import java.util.List;

public class TreeSort {
    private static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value)
            root.left = insertRec(root.left, value);
        else if (value > root.value)
            root.right = insertRec(root.right, value);
        return root;
    }

    public List<Integer> treeSort(List<Integer> list) {
        for (int value : list) {
            insert(value);
        }
        List<Integer> sortedList = new ArrayList<>();
        inorderRec(root, sortedList);
        return sortedList;
    }

    private void inorderRec(Node root, List<Integer> sortedList) {
        if (root != null) {
            inorderRec(root.left, sortedList);
            sortedList.add(root.value);
            inorderRec(root.right, sortedList);
        }
    }
}
