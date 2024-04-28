

public class MyRunnable implements Runnable {
    int sleepTime;

    public MyRunnable(int sleepTime){
        this.sleepTime = sleepTime;

    }
    @Override
    public void run() {
        
        for (int i = 1; i < 11; i++) {
            System.out.println(Thread.currentThread().getName() + " y la iteracion es: " + i);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }

    
    
}