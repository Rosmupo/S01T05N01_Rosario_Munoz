EJERCICIO 1

//Para ejecutar el ejercicio 1, se ha ejecutado un archivo .java que contiene el código que da respuesta al ejercicio 1.
public class App1 {

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

//En la terminal se han intruducido las siguientes instrucciones.

(base) NOS-ORS-843:Pruebas Rosario$ javac App1.java
(base) NOS-ORS-843:Pruebas Rosario$ java App1.java

//La terminal ha devuelto la siguiente información:
[.DS_Store, .localized, Adobe Acrobat Reader DC.app, Adobe Digital Editions 4.5.app, Adobe Digital Editions.app, AJA System Test Lite.app, Anaconda-Navigator.app, App Store.app, Automator.app, BlueStacks.app, Books.app, Calculator.app, Calendar.app, Chess.app, Contacts.app, Dashboard.app, Dictionary.app, Discord.app, Docker.app, Document Writer.app, Eclipse Installer.app, FaceTime.app, FE File Explorer.app, Font Book.app, GitHub Desktop.app, Google Chrome.app, Grammarly for Safari.app, Home.app, Image Capture.app, Install macOS Monterey.app, IntelliJ IDEA.app, iTunes.app, Launchpad.app, Mail.app, Maps.app, Mendeley Desktop.app, Messages.app, Microsoft Excel.app, Microsoft Lync.app, Microsoft Office 2011, Microsoft OneNote.app, Microsoft Outlook.app, Microsoft PowerPoint.app, Microsoft Teams.app, Microsoft Word.app, Mission Control.app, MySQLWorkbench.app, News.app, Notes.app, OneDrive.app, Paint X.app, Photo Booth.app, Photos.app, Postgres.app, Postman.app, Preview.app, Python 3.10, PythonTurtle.app, Qfinder by QNAP.app, QuickTime Player.app, Reminders.app, Safari.app, Siri.app, Skype.app, Slack.app, Spotify.app, Stickies.app, Stocks.app, Sublime Text 2.app, Sublime Text.app, System Preferences.app, Telegram.app, TextEdit.app, Time Machine.app, TimeMachineEditor.app, unrarpro2.app, Unzip - RAR ZIP 7Z Unarchiver.app, Utilities, VLC.app, VoiceMemos.app, WhatsApp.app, WinZip.app, WinZip.localized, XAMPP, zoom.us.app]

EJERCICIO 2
//Para ejecutar el ejercicio 1, se ha ejecutado un archivo .java que contiene el código que da respuesta al ejercicio 2.
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

public class App2 {

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

//En la terminal se han intruducido las siguientes instrucciones.

(base) NOS-ORS-843:Pruebas Rosario$ javac App2.java
(base) NOS-ORS-843:Pruebas Rosario$ java App2.java

//La terminal ha devuelto la siguiente información:

F App.class Fecha de la última modificación 15/5/2022
F App.java Fecha de la última modificación 15/5/2022
F EX5.ser Fecha de la última modificación 15/5/2022
F Ex3.txt Fecha de la última modificación 15/5/2022
D carpeta_a
F 4444.txt Fecha de la última modificación 11/5/2022
D maria
F 22222.txt Fecha de la última modificación 10/5/2022
F 4444.txt Fecha de la última modificación 11/5/2022
D pepe
F 11111.txt Fecha de la última modificación 10/5/2022
D carpeta_b
D laura
F 3333.txt Fecha de la última modificación 10/5/2022
D pedro
F 55555.txt Fecha de la última modificación 11/5/2022
D carpeta_c
D juan
F 444444.txt Fecha de la última modificación 11/5/2022

EJERCICIO 3
//Para ejecutar el ejercicio 1, se ha ejecutado un archivo .java que contiene el código que da respuesta al ejercicio 3.
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


public class App3 {

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


//En la terminal se han intruducido las siguientes instrucciones.

(base) NOS-ORS-843:Pruebas Rosario$ javac App3.java
(base) NOS-ORS-843:Pruebas Rosario$ java App3.java

//Las instrucciones han generado un archivo .txt en el que se lista el directorio:

EJERCICIO 4
//Para ejecutar el ejercicio 1, se ha ejecutado un archivo .java que contiene el código que da respuesta al ejercicio 4.
package EX4;

//        - Exercici 4
//        Afegeix la funcionalitat de llegir qualsevol fitxer TXT i mostra el
//        seu contingut per consola.

import java.io.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App4 {

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

//En la terminal se han intruducido las siguientes instrucciones.

(base) NOS-ORS-843:Pruebas Rosario$ javac App4.java
(base) NOS-ORS-843:Pruebas Rosario$ java App4.java

//La terminal ha devuelto la siguiente información:
F App.class Fecha de la última modificación 15/5/2022
F App3.class Fecha de la última modificación 15/5/2022
F App4.class Fecha de la última modificación 15/5/2022
F App4.java Fecha de la última modificación 15/5/2022
F EX5.ser Fecha de la última modificación 15/5/2022
F Ex3.txt Fecha de la última modificación 15/5/2022
D carpeta_a Fecha de la última modificación 11/5/2022
F 4444.txt Fecha de la última modificación 11/5/2022
D maria Fecha de la última modificación 11/5/2022
F 22222.txt Fecha de la última modificación 10/5/2022
F 4444.txt Fecha de la última modificación 11/5/2022
D pepe Fecha de la última modificación 10/5/2022
F 11111.txt Fecha de la última modificación 10/5/2022
D carpeta_b Fecha de la última modificación 11/5/2022
D laura Fecha de la última modificación 10/5/2022
F 3333.txt Fecha de la última modificación 10/5/2022
D pedro Fecha de la última modificación 11/5/2022
F 55555.txt Fecha de la última modificación 11/5/2022
D carpeta_c Fecha de la última modificación 11/5/2022
D juan Fecha de la última modificación 11/5/2022
F 444444.txt Fecha de la última modificación 11/5/2022

EJERCICIO 5
//Para ejecutar el ejercicio 1, se ha utilizado el comando Javac para todos los archivos contenidos en la carpeta donde se encuentran las clases del proyecto que dan respuesta al ejercicio 5.
package EX5;

import java.io.*;
//        - Exercici 5
//        Ara el programa ha de serialitzar un Objecte Java a un fitxer
//        .ser i després l’ha de desserialitzar.



public class App {

    public static void main(String[] args) {
        //método para convertir un objeto en una secuencia de bytes para almacenarlo en un archivo .ser.
        serialization();
        //método para leer una secuencia de bytes y transformarlo en un objeto
        deserialization();

    }

///////////FUNCIONES
    private static void serialization(){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        Client client;
        try {
            fileOutputStream = new FileOutputStream("/Users/Rosario/Pruebas/EX5.ser");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            client = new Client(1,"Sofía", 4, "Barcelona");
            objectOutputStream.writeObject(client);

            client = new Client(2,"Ángeles", 34, "Berlín");
            objectOutputStream.writeObject(client);

            client = new Client(3,"Mercedes", 42, "Milán");
            objectOutputStream.writeObject(client);

            client = new Client(4,"Ximena", 45, "Buenos Aires");
            objectOutputStream.writeObject(client);

            client = new Client(5,"Santiago", 33, "Buenos Aires");
            objectOutputStream.writeObject(client);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }
                if(objectOutputStream != null){
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
package EX5;

import java.io.Serializable;

public class Client implements Serializable {

    private int id;
    private String name;
    private int age;
    private String city;

    public Client() {
    }

    public Client(int id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int edad) {
        this.age = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}



    private static void deserialization(){
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        Client client;

        try {
            fileInputStream = new FileInputStream("/Users/Rosario/Pruebas/EX5.ser");
            objectInputStream = new ObjectInputStream(fileInputStream);

            client = (Client) objectInputStream.readObject();
            System.out.println(client.getId() + " " + client.getName() + " " + client.getAge() + " " + client.getCity());

            client = (Client) objectInputStream.readObject();
            System.out.println(client.getId() + " " + client.getName() + " " + client.getAge() + " " + client.getCity());

            client = (Client) objectInputStream.readObject();
            System.out.println(client.getId() + " " + client.getName() + " " + client.getAge() + " " + client.getCity());

            client = (Client) objectInputStream.readObject();
            System.out.println(client.getId() + " " + client.getName() + " " + client.getAge() + " " + client.getCity());

            client = (Client) objectInputStream.readObject();
            System.out.println(client.getId() + " " + client.getName() + " " + client.getAge() + " " + client.getCity());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

//En este caso al tratarse de dos archivos que estan guardados dentro de un paquete se ha utilizado el comando *.java, para afectar a todos los archivos java del paquete.

(base) NOS-ORS-843:EX5 Rosario$ javac *.java

// posteriormente se ejecuta el archivo que contiene el main

(base) NOS-ORS-843:EX5 Rosario$ java App.java


//La terminal ha devuelto la siguiente información:
1 Sofía 4 Barcelona
2 Ángeles 34 Berlín
3 Mercedes 42 Milán
4 Ximena 45 Buenos Aires
5 Santiago 33 Buenos Aires

