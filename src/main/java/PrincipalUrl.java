import metodos.strings.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PrincipalUrl {

    public List<String> extractUrl() {
        List<String> urls = new ArrayList<>();
        String url = "jdbc:sqlite:./src/main/resources/bibliometria.db";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt
                        .executeQuery(
                                "SELECT REPLACE(REPLACE(url, CHAR(13), ''), CHAR(10), '') AS url FROM publicaciones WHERE url IS NOT NULL ORDER BY id_publicacion")) {

            while (rs.next()) {
                urls.add(rs.getString("url"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return urls;
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
        PrincipalUrl principalUrl = new PrincipalUrl();

        List<String> urlsTim = principalUrl.extractUrl();
        List<String> urlsComb = principalUrl.extractUrl();
        List<String> urlsSelection = principalUrl.extractUrl();
        List<String> urlsTree = principalUrl.extractUrl();
        List<String> urlsPigeonhole = principalUrl.extractUrl();
        List<String> urlsBucket = principalUrl.extractUrl();
        List<String> urlsQuick = principalUrl.extractUrl();
        List<String> urlsHeap = principalUrl.extractUrl();
        List<String> urlsBitonic = principalUrl.extractUrl();
        List<String> urlsGnome = principalUrl.extractUrl();
        List<String> urlsBinaryInsertion = principalUrl.extractUrl();
        List<String> urlsRadix = principalUrl.extractUrl();

        long startTime = System.currentTimeMillis();
        timSort.timSort(urlsTim);
        long endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución de TimSort: " + (endTime - startTime) + " milisegundos");

        startTime = System.currentTimeMillis();
        combSort.combSort(urlsComb);
        endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución de CombSort: " + (endTime - startTime) + " milisegundos");

        startTime = System.currentTimeMillis();
        SelectionSort.selectionSort(urlsSelection);
        endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución de SelectionSort: " + (endTime - startTime) + " milisegundos");

        startTime = System.currentTimeMillis();
        urlsTree = treeSort.treeSort(urlsTree);
        endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución de TreeSort: " + (endTime - startTime) + " milisegundos");

        startTime = System.currentTimeMillis();
        pigeonholeSort.pigeonholeSort(urlsPigeonhole);
        endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución de PigeonholeSort: " + (endTime - startTime) + " milisegundos");

        ;
        startTime = System.currentTimeMillis();
        bucketSort.bucketSort(urlsBucket);
        endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución de BucketSort: " + (endTime - startTime) + " milisegundos");

        startTime = System.currentTimeMillis();
        quickSort.quickSort(urlsQuick, 0, urlsQuick.size() - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución de QuickSort: " + (endTime - startTime) + " milisegundos");

        startTime = System.currentTimeMillis();
        heapSort.sort(urlsHeap);
        endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución de HeapSort: " + (endTime - startTime) + " milisegundos");

        startTime = System.currentTimeMillis();
        bitonicSort.bitonicSort(urlsBitonic, false);
        endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución de BitonicSort: " + (endTime - startTime) + " milisegundos");

        startTime = System.currentTimeMillis();
        gnomeSort.gnomeSort(urlsGnome);
        endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución de GnomeSort: " + (endTime - startTime) + " milisegundos");

        startTime = System.currentTimeMillis();
        binaryInsertionSort.binaryInsertionSort(urlsBinaryInsertion);
        endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución de BinaryInsertionSort: " + (endTime - startTime) + " milisegundos");

        startTime = System.currentTimeMillis();
        radixSort.radixSort(urlsRadix);
        endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución de RadixSort: " + (endTime - startTime) + " milisegundos");

        for(String url : urlsPigeonhole) {
            System.out.println(url);
        }
    }
}
