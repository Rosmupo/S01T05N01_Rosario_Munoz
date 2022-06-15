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
