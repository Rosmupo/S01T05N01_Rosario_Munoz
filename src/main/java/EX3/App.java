package EX3;

//        - Exercici 3
//        Modifica l’exercici anterior. Ara, en lloc de mostrar el resultat per
//        la pantalla, guarda el resultat en un fitxer TXT.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class App {

    public static final String DIRECTORY = "/Users/Rosario/Pruebas";

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter(DIRECTORY + "/Ex3.txt");
        listFiles(DIRECTORY,fileWriter);
        fileWriter.close();
    }

//////////FUNCIONES
    private static void writeFileTxt(String dataFile, FileWriter fileWriter) throws IOException {
        fileWriter.write(dataFile + "\n");
    }

    private static File[] listAlphabetical(String namePath) {
        File file = new File(namePath);
        File[] files = file.listFiles();
        Arrays.sort(files);
        return files;
    }

    public static void listFiles(String pathName, FileWriter fileWriter) throws IOException {
        //Llamada al método que ordena alfabéticamente.
        File[] files = listAlphabetical(pathName);
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (!file.isDirectory()) {
                    //Llamada al método que escribe el archivo.
                    writeFileTxt("F "+ file.getName() + printDate(file), fileWriter);
                } else {
                    writeFileTxt("D "+ file.getName() + printDate(file), fileWriter);
                    //recursividad
                    listFiles(file.getAbsolutePath(), fileWriter);
                }
            }
        }
    }

    public static String printDate(File file) {
        long lastModified = file.lastModified();
        Date date = new Date(lastModified);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        String day = Integer.toString(calendar.get(Calendar.DATE));
        String month = Integer.toString(calendar.get(Calendar.MONTH));
        String year = Integer.toString(calendar.get(Calendar.YEAR));
       return " Fecha de la última modificación " + day + "/" + month + "/" + year;
    }
}
