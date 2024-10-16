import metodos.strings.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PrincipalPrimerAutor {

    public List<String> extractPrimerAutor() {
        List<String> primerAutores = new ArrayList<>();
        String url = "jdbc:sqlite:./src/main/resources/bibliometria.db";


        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT primer_autor FROM publicaciones WHERE primer_autor IS NOT NULL ORDER BY id_publicacion")) {

            while (rs.next()) {
                primerAutores.add(rs.getString("primer_autor"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return primerAutores;
    }

    public static void main(String[] args) {
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
        PrincipalPrimerAutor principalPrimerAutor = new PrincipalPrimerAutor();

        List<String> primerAutoresTim = principalPrimerAutor.extractPrimerAutor();
        List<String> primerAutoresComb = principalPrimerAutor.extractPrimerAutor();
        List<String> primerAutoresSelection = principalPrimerAutor.extractPrimerAutor();
        List<String> primerAutoresTree = principalPrimerAutor.extractPrimerAutor();
        List<String> primerAutoresPigeonhole = principalPrimerAutor.extractPrimerAutor();
        List<String> primerAutoresBucket = principalPrimerAutor.extractPrimerAutor();
        List<String> primerAutoresQuick = principalPrimerAutor.extractPrimerAutor();
        List<String> primerAutoresHeap = principalPrimerAutor.extractPrimerAutor();
        List<String> primerAutoresBitonic = principalPrimerAutor.extractPrimerAutor();
        List<String> primerAutoresGnome = principalPrimerAutor.extractPrimerAutor();
        List<String> primerAutoresBinaryInsertion = principalPrimerAutor.extractPrimerAutor();
        List<String> primerAutoresRadix = principalPrimerAutor.extractPrimerAutor();

        long startTime = System.currentTimeMillis();
        timSort.timSort(primerAutoresTim);
        long endTime = System.currentTimeMillis();
        System.out.println("TimSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        combSort.combSort(primerAutoresComb);
        endTime = System.currentTimeMillis();
        System.out.println("CombSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        SelectionSort.selectionSort(primerAutoresSelection);
        endTime = System.currentTimeMillis();
        System.out.println("SelectionSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        primerAutoresTree= treeSort.treeSort(primerAutoresTree);
        endTime = System.currentTimeMillis();
        System.out.println("TreeSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        pigeonholeSort.pigeonholeSort(primerAutoresPigeonhole);
        endTime = System.currentTimeMillis();
        System.out.println("PigeonholeSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        bucketSort.bucketSort(primerAutoresBucket);
        endTime = System.currentTimeMillis();
        System.out.println("BucketSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        quickSort.quickSort(primerAutoresQuick, 0, primerAutoresQuick.size() - 1);
        endTime = System.currentTimeMillis();
        System.out.println("QuickSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        heapSort.sort(primerAutoresHeap);
        endTime = System.currentTimeMillis();
        System.out.println("HeapSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        bitonicSort.bitonicSort(primerAutoresBitonic,false);
        endTime = System.currentTimeMillis();
        System.out.println("BitonicSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        gnomeSort.gnomeSort(primerAutoresGnome);
        endTime = System.currentTimeMillis();
        System.out.println("GnomeSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        binaryInsertionSort.binaryInsertionSort(primerAutoresBinaryInsertion);
        endTime = System.currentTimeMillis();
        System.out.println("BinaryInsertionSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        radixSort.radixSort(primerAutoresRadix);
        endTime = System.currentTimeMillis();
        System.out.println("RadixSort: " + (endTime - startTime) + " ms");



    }
}
