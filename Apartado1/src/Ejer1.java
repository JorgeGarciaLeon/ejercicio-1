import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Ejer1 {
    public static void main(String[] args){
        Scanner intro = new Scanner(System.in);

        System.out.println("Introduzaca el numero de ventanas a ejecutar");
        int numRepes = intro.nextInt();

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("chromium");
        ArrayList<Process> pidProcesos = new ArrayList<>();

        Process process = null;
        try {
            for (int i = 0; i < numRepes; i++) {
                process = processBuilder.start();
                pidProcesos.add(process);
            }

            for (Process proceso1 : pidProcesos) {
                proceso1.waitFor();
            }

        }catch (IOException | InterruptedException e) {
            e.printStackTrace();


        }catch (Exception err){
                System.out.println("err" + err);
        }

    }
}
