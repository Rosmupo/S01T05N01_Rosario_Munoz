package EX2;

//        - Exercici 2
//        Afegeix a la classe de l’exercici anterior, la funcionalitat de
//        llistar un arbre de directoris amb el contingut de tots els seus
//        nivells (recursivament) de manera que s'imprimeixin en pantalla en
//        ordre alfabètic dins de cada nivell, indicant a més si és un directori
//        (D) o un fitxer (F), i la seva última data de modificació.

import java.io.File;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {

    public static final String DIRECTORY = "/Users/Rosario/Pruebas";

    public static void main(String[] args) {
        //Llamada al método que lista un árbol de directorios de manera recursiva.
        listFiles(DIRECTORY);
    }
//////////FUNCIONES
    public static void listFiles(String pathName) {
        //Llamada al método que lista alfabéticamente
        File[] files = listAlphabetical(pathName);
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (!file.isDirectory()) {
                    System.out.print("F " + file.getName());
                    //Llamada al método que imprime la última fecha de modificación del archivo
                    printDate(file);
                } else {
                    System.out.println("D " + file.getName());
                    listFiles(file.getAbsolutePath());
                }
            }
        }
    }

    private static File[] listAlphabetical(String namePath) {
        File file = new File(namePath);
        File[] files = file.listFiles();
        Arrays.sort(files);
        return files;
    }

    public static void printDate(File file) {
        long lastModified = file.lastModified();
        Date date = new Date(lastModified);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        String day = Integer.toString(calendar.get(Calendar.DATE));
        String month = Integer.toString(calendar.get(Calendar.MONTH));
        String year = Integer.toString(calendar.get(Calendar.YEAR));
        System.out.println(" Fecha de la última modificación " + day + "/" + month + "/" + year);
    }
}
