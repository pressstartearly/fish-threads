import java.util.concurrent.*;
import java.util.TimerTask;
import java.util.Timer;

// Main Class 
public class HouseHold 
{ 
    public static void main(String[] args) 
    { 
        Semaphore sem = new Semaphore(1);

        CareGiver me = new CareGiver(sem, "Caleb");
        CareGiver so = new CareGiver(sem, "Sarah");
        me.start();
        so.start();

        Timer t = new Timer( );
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                System.out.println("It's a new day!");
                sem.release();
            }
        }, 0, 10000);
    } 
} 