import metodos.strings.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PrincipalJournal {

    public List<String> extractJournal() {
        List<String> journals = new ArrayList<>();
        String url = "jdbc:sqlite:./src/main/resources/bibliometria.db";


        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT journal FROM publicaciones WHERE journal IS NOT NULL ORDER BY id_publicacion")) {

            while (rs.next()) {
                journals.add(rs.getString("journal"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return journals;
    }

    public static void main(String[]args){
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
        PrincipalJournal principalJournal = new PrincipalJournal();

        List<String> journalsTim = principalJournal.extractJournal();
        List<String> journalsComb = principalJournal.extractJournal();
        List<String> journalsSelection = principalJournal.extractJournal();
        List<String> journalsTree = principalJournal.extractJournal();
        List<String> journalsPigeonhole = principalJournal.extractJournal();
        List<String> journalsBucket = principalJournal.extractJournal();
        List<String> journalsQuick = principalJournal.extractJournal();
        List<String> journalsHeap = principalJournal.extractJournal();
        List<String> journalsBitonic = principalJournal.extractJournal();
        List<String> journalsGnome = principalJournal.extractJournal();
        List<String> journalsBinaryInsertion = principalJournal.extractJournal();
        List<String> journalsRadix = principalJournal.extractJournal();

        long startTime = System.currentTimeMillis();
        timSort.timSort(journalsTim);
        long endTime = System.currentTimeMillis();
        System.out.println("TimSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        combSort.combSort(journalsComb);
        endTime = System.currentTimeMillis();
        System.out.println("CombSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        SelectionSort.selectionSort(journalsSelection);
        endTime = System.currentTimeMillis();
        System.out.println("SelectionSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        journalsTree = treeSort.treeSort(journalsTree);
        endTime = System.currentTimeMillis();
        System.out.println("TreeSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        pigeonholeSort.pigeonholeSort(journalsPigeonhole);
        endTime = System.currentTimeMillis();
        System.out.println("PigeonholeSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        bucketSort.bucketSort(journalsBucket);
        endTime = System.currentTimeMillis();
        System.out.println("BucketSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        quickSort.quickSort(journalsQuick,0,journalsQuick.size()-1);
        endTime = System.currentTimeMillis();
        System.out.println("QuickSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        heapSort.sort(journalsHeap);
        endTime = System.currentTimeMillis();
        System.out.println("HeapSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        bitonicSort.bitonicSort(journalsBitonic, false);
        endTime = System.currentTimeMillis();
        System.out.println("BitonicSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        gnomeSort.gnomeSort(journalsGnome);
        endTime = System.currentTimeMillis();
        System.out.println("GnomeSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        binaryInsertionSort.binaryInsertionSort(journalsBinaryInsertion);
        endTime = System.currentTimeMillis();
        System.out.println("BinaryInsertionSort: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        radixSort.radixSort(journalsRadix);
        endTime = System.currentTimeMillis();
        System.out.println("RadixSort: " + (endTime - startTime) + " ms");

        System.out.println("n:"+journalsTim.size());

    }
}
