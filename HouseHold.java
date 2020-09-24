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
                // This shouldn't happen except possibily in the very beginning while the caregivers are moving in. AKA when the threads are first starting.
                // If a new day happens at the beginning before the threads finish initializing it could happen. In this case the fish would get fed twice
                // because there would be 2 available permits. I could count this as the fish dying but this will never happen except for the case stated
                // above.
                if(sem.availablePermits() < 1) {
                    sem.release();
                }
            }
        }, 0, 10000);
    } 
} 