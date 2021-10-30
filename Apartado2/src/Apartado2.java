import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Apartado2 {
    public static void main(String[] args){
        Scanner intro = new Scanner(System.in);

        System.out.println("Introduzaca el numero de ventanas a ejecutar");
        int numRepes = intro.nextInt();

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("chromium");
        ArrayList<Process> pidProcesos = new ArrayList<>();
        ArrayList<String> startTime = new ArrayList();
        ArrayList<String> endTime = new ArrayList();


        Process process = null;
        try {
            System.out.println("------------------------Hora de inicio------------------------");
            for (int i = 0; i < numRepes; i++) {
                Calendar hora = new GregorianCalendar();
                process = processBuilder.start();
                pidProcesos.add(process);
                System.out.println(hora.get(Calendar.HOUR_OF_DAY) + ":" + hora.get(Calendar.MINUTE) + ":" + hora.get(Calendar.SECOND) + ":" + hora.get(Calendar.MILLISECOND));
            }

            System.out.println("------------------------Hora de fin------------------------");
            for (Process proceso1 : pidProcesos) {
                proceso1.waitFor(500, TimeUnit.MILLISECONDS);
                Calendar hora = new GregorianCalendar();
                proceso1.destroy();
                System.out.println(hora.get(Calendar.HOUR_OF_DAY) + ":" + hora.get(Calendar.MINUTE) + ":" + hora.get(Calendar.SECOND) + ":" + hora.get(Calendar.MILLISECOND));
            }

        }catch (IOException | InterruptedException e) {
            e.printStackTrace();


        }catch (Exception err){
            System.out.println("err" + err);
        }

    }
}