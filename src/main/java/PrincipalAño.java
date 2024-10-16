import metodos.ints.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PrincipalAño {

    public List<Integer> extractAño() {
        List<Integer> años = new ArrayList<>();
        String url = "jdbc:sqlite:./src/main/resources/bibliometria.db";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(
                        "SELECT anio_publicacion FROM publicaciones WHERE anio_publicacion IS NOT NULL ORDER BY id_publicacion")) {

            while (rs.next()) {
                años.add(rs.getInt("anio_publicacion"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return años;
    }

    public static void main(String[]args) {
        TimSort timSort = new TimSort();
        CombSort combSort = new CombSort();
        SelectionSort SelectionSort = new SelectionSort();
        TreeSort treeSort = new TreeSort();
        PigeonholeSort pigeonholeSort = new PigeonholeSort();
        BucketSort bucketSort = new BucketSort();
        QuickSort quickSort = new QuickSort();
        HeapSort heapSort = new HeapSort();
        BitonicSort bitonicSort = new BitonicSort();
        GnomeSort gnomeSort = new GnomeSort();
        BinaryInsertionSort binaryInsertionSort = new BinaryInsertionSort();
        RadixSort radixSort = new RadixSort();
        PrincipalAño principalAño = new PrincipalAño();

        List<Integer> añosTim = principalAño.extractAño();
        List<Integer> añosComb = principalAño.extractAño();
        List<Integer> añosSelection = principalAño.extractAño();
        List<Integer> añosTree = principalAño.extractAño();
        List<Integer> añosPigeonhole = principalAño.extractAño();
        List<Integer> añosBucket = principalAño.extractAño();
        List<Integer> añosQuick = principalAño.extractAño();
        List<Integer> añosHeap = principalAño.extractAño();
        List<Integer> añosBitonic = principalAño.extractAño();
        List<Integer> añosGnome = principalAño.extractAño();
        List<Integer> añosBinaryInsertion = principalAño.extractAño();
        List<Integer> añosRadix = principalAño.extractAño();

        long startTime = System.currentTimeMillis();
        timSort.timSort(añosTim);
        long endTime = System.currentTimeMillis();
        System.out.println("TimSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        combSort.combSort(añosComb);
        endTime = System.currentTimeMillis();
        System.out.println("CombSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        SelectionSort.selectionSort(añosSelection);
        endTime = System.currentTimeMillis();
        System.out.println("SelectionSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        añosTree= treeSort.treeSort(añosTree);
        endTime = System.currentTimeMillis();
        System.out.println("TreeSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        pigeonholeSort.pigeonholeSort(añosPigeonhole);
        endTime = System.currentTimeMillis();
        System.out.println("PigeonholeSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        bucketSort.bucketSort(añosBucket);
        endTime = System.currentTimeMillis();
        System.out.println("BucketSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        quickSort.sort(añosQuick);
        endTime = System.currentTimeMillis();
        System.out.println("QuickSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        heapSort.sort(añosHeap);
        endTime = System.currentTimeMillis();
        System.out.println("HeapSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        bitonicSort.sort(añosBitonic);
        endTime = System.currentTimeMillis();
        System.out.println("BitonicSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        gnomeSort.sort(añosGnome);
        endTime = System.currentTimeMillis();
        System.out.println("GnomeSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        binaryInsertionSort.binaryInsertionSort(añosBinaryInsertion);
        endTime = System.currentTimeMillis();
        System.out.println("BinaryInsertionSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        radixSort.radixSort(añosRadix);
        endTime = System.currentTimeMillis();
        System.out.println("RadixSort: " + (endTime - startTime) + " ms");



    }

}
