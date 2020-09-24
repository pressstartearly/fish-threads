// Main Class 
public class HouseHold 
{ 
    public static void main(String[] args) 
    { 
        int n = 8; // Number of threads 
        for (int i=0; i<n; i++) 
        { 
            CareGiver object = new CareGiver(); 
            object.start(); 
        } 
    } 
} 