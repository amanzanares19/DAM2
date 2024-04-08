import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        
        /* Proceso example
        try {
            ProcessBuilder builder = new ProcessBuilder("notepad.exe");
            Process process = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        } */

        /***
         *  Actividad de hilos
         * 5 hilos distintos que tengan un bucle hasta 10
         * en cada vuelta imprimir nombre del hilo e iteracion actual
         * hacer herencia e implementacion
         * hacer sleep del hilo en cada bucle
         *  */

        MyRunnable runnable = new MyRunnable(1000);
        MyRunnable2 runnable2 = new MyRunnable2(3000);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable2);
        Thread thread5 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        
    }
}
