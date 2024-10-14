import metodos.strings.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Principal {

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
        TreeSort treeSort = new TreeSort();
        PigeonholeSort pigeonholeSort = new PigeonholeSort();
        BucketSort bucketSort = new BucketSort();
        Principal principal = new Principal();

        List<String> titulosTim = principal.extractTitulos();
        List<String> titulosComb = principal.extractTitulos();
        List<String> titulosSele = principal.extractTitulos();
        List<String> titulosTree = principal.extractTitulos();
        List<String> titulosPigeon = principal.extractTitulos();
        List<String> titulosBucket = principal.extractTitulos();

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

        for(String titulos: titulosBucket){
            System.out.println(titulos);
        }
    }

}
