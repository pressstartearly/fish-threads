import java.util.concurrent.Semaphore;
import java.util.Random;

class CareGiver extends Thread 
{ 
    Semaphore sem; 
    String name; 
    Random r = new Random();

    public CareGiver(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
    }
    
    public void run() 
    { 
        try
        {
            System.out.println(this.name + " moved into the apartment!");
            while(true) {
                Thread.sleep(r.nextInt(9000-3000) + 3000);
                if(sem.tryAcquire()) {
                    System.out.println(this.name + " feed the fish!");
                } else {
                    System.out.println(this.name + " tried to feed the fish but he was already fed.");
                }
            }
        } 
        catch (Exception e) 
        {  
            System.out.println ("An error has occurred: " + e.toString()); 
        } 
    } 
} 