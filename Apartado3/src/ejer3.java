import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ejer3 {
    public static void main(String[] args) {
        Scanner intro = new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero a comprobar");
        String rute = intro.nextLine();

        Process process = null;
        File file = new File(rute);
        ProcessBuilder procesBuilder = new ProcessBuilder();
        String command = "";
        procesBuilder.command("cat", rute,"|","wc","-l");


        Path path = Paths.get(rute);
        if(path.toFile().isFile()){

            try{
                process = procesBuilder.start();

             }catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("no existe");
        }
    }
}
