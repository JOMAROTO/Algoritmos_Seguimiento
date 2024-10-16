import metodos.strings.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PrincipalTitulo {

    public List<String> extractTitulos() {
        List<String> titulos = new ArrayList<>();
        String url = "jdbc:sqlite:./src/main/resources/bibliometria.db";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT titulo FROM publicaciones ORDER BY id_publicacion")) {

            while (rs.next()) {
                titulos.add(rs.getString("titulo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return titulos;
    }

    // main para ejecutar los metodos con el campo de titulo
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
        PrincipalTitulo principalTitulo = new PrincipalTitulo();


        List<String> titulosTim = principalTitulo.extractTitulos();
        List<String> titulosComb = principalTitulo.extractTitulos();
        List<String> titulosSele = principalTitulo.extractTitulos();
        List<String> titulosTree = principalTitulo.extractTitulos();
        List<String> titulosPigeon = principalTitulo.extractTitulos();
        List<String> titulosBucket = principalTitulo.extractTitulos();
        List<String> titulosQuick = principalTitulo.extractTitulos();
        List<String> titulosHeap = principalTitulo.extractTitulos();
        List<String> titulosBitonic = principalTitulo.extractTitulos();
        List<String> titulosGnome = principalTitulo.extractTitulos();
        List<String> titulosBinary = principalTitulo.extractTitulos();
        List<String> titulosRadix = principalTitulo.extractTitulos();

        long startTime = System.currentTimeMillis();
        timSort.timSort(titulosTim);
        long endTime = System.currentTimeMillis();
        System.out.println("TimSort execution time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        combSort.combSort(titulosComb);
        endTime = System.currentTimeMillis();
        System.out.println("CombSort execution time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        SelectionSort.selectionSort(titulosSele);
        endTime = System.currentTimeMillis();
        System.out.println("SelectionSort execution time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        titulosTree = treeSort.treeSort(titulosTree);
        endTime = System.currentTimeMillis();
        System.out.println("TreeSort execution time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        pigeonholeSort.pigeonholeSort(titulosPigeon);
        endTime = System.currentTimeMillis();
        System.out.println("PigeonholeSort execution time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        bucketSort.bucketSort(titulosBucket);
        endTime = System.currentTimeMillis();
        System.out.println("BucketSort execution time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        quickSort.quickSort(titulosQuick, 0, titulosQuick.size() - 1);
        endTime = System.currentTimeMillis();
        System.out.println("QuickSort execution time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        heapSort.sort(titulosHeap);
        endTime = System.currentTimeMillis();
        System.out.println("HeapSort execution time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        bitonicSort.bitonicSort(titulosBitonic, false);
        endTime = System.currentTimeMillis();
        System.out.println("BitonicSort execution time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        gnomeSort.gnomeSort(titulosGnome);
        endTime = System.currentTimeMillis();
        System.out.println("GnomeSort execution time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        binaryInsertionSort.binaryInsertionSort(titulosBinary);
        endTime = System.currentTimeMillis();
        System.out.println("BinaryInsertionSort execution time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        radixSort.radixSort(titulosRadix);
        endTime = System.currentTimeMillis();
        System.out.println("RadixSort execution time: " + (endTime - startTime) + " ms");


    }

}
