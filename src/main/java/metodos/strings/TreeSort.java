package metodos.strings;
import java.util.ArrayList;
import java.util.List;



public class TreeSort {
    private class Node {
        String data;
        Node left, right;

        public Node(String item) {
            data = item;
            left = right = null;
        }
    }

    private Node root;

    public TreeSort() {
        root = null;
    }

    private void insert(String data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, String data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data.compareTo(root.data) < 0)
            root.left = insertRec(root.left, data);
        else if (data.compareTo(root.data) > 0)
            root.right = insertRec(root.right, data);
        return root;
    }

    private void inorderRec(Node root, List<String> result) {
        if (root != null) {
            inorderRec(root.left, result);
            result.add(root.data);
            inorderRec(root.right, result);
        }
    }

    public List<String> treeSort(List<String> titulos) {
        for (String titulo : titulos) {
            insert(titulo);
        }
        List<String> sortedList = new ArrayList<>();
        inorderRec(root, sortedList);
        return sortedList;
    }
}
