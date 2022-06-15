package EX1;

//        - Exercici 1
//        Crea una classe que llisti alfabèticament el contingut
//        d'un directori rebut per paràmetre.

import java.io.File;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        //Ruta del directorio
        String namePath = "/Applications";
        //Llamada al método que recibe la ruta del directorio y ordena la lista
        listAlphabetical(namePath);
    }
///////////Funciones
    private static void listAlphabetical(String namePath) {
        File file = new File(namePath);
        String[] listFiles = file.list();
        Arrays.sort(listFiles, String.CASE_INSENSITIVE_ORDER);
        for (String name : listFiles) {
            System.out.println(name);
        }
    }
}
