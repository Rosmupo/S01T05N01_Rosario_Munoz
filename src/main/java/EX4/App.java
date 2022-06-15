package EX4;

//        - Exercici 4
//        Afegeix la funcionalitat de llegir qualsevol fitxer TXT i mostra el
//        seu contingut per consola.

import java.io.*;
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
        //Llamada al método que lee un archivo txt e imprime la información por consola
        readFileTxt();

    }

//////////FUNCIONES
    public static void listFiles(String pathName, FileWriter fileWriter) throws IOException {
        File[] files = listAlphabetical(pathName);
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (!file.isDirectory()) {
                    writeFileTxt("F "+ file.getName() + printDate(file), fileWriter);

                } else {
                    writeFileTxt("D "+ file.getName() + printDate(file), fileWriter);
                    listFiles(file.getAbsolutePath(), fileWriter);
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

    private static void writeFileTxt(String dataFile, FileWriter fileWriter) throws IOException {
        fileWriter.write(dataFile + "\n");
    }

    private static void readFileTxt()  {
        try {
            FileReader fileReader = new FileReader(DIRECTORY + "/Ex3.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            System.out.println(bufferedReader.readLine());
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            fileReader.close();
        } catch (IOException e) {
          System.out.println("Archivo no encontrado");
        }
    }

    public static String printDate(File f) {
        long lastModified = f.lastModified();
        Date date = new Date(lastModified);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        String day = Integer.toString(calendar.get(Calendar.DATE));
        String month = Integer.toString(calendar.get(Calendar.MONTH));
        String year = Integer.toString(calendar.get(Calendar.YEAR));
        return " Fecha de la última modificación " + day + "/" + month + "/" + year;
    }
}
