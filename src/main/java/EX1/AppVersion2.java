package EX1;

//Crea una classe que llisti alfabèticament el contingut
// d'un directori rebut per paràmetre.

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppVersion2 {

    public static void main(String[] args) {

        final String name_directory = "/Applications";
        List<String> myFiles = new ArrayList<>();

        //Ejercicio resuelto utilizando la interfaz Directory Stream
        try (DirectoryStream<Path> myDirectoryStream = Files.newDirectoryStream(Paths.get(name_directory))) {
            for (Path path : myDirectoryStream) myFiles.add(path.getFileName().toString());
            Collections.sort(myFiles, String.CASE_INSENSITIVE_ORDER);
            System.out.println(myFiles);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

