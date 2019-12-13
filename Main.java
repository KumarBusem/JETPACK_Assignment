import java.util.*; 
import java.io.*; 
  
class Main { 
    // Returns minimum number of hops to reach compartmentsArray[hiddenCompartment] from compartmentsArray[startingPoint] 
    static int minHops(int compartmentsArray[], int startingPoint, int hiddenCompartment) 
    { 
        if (hiddenCompartment == startingPoint) 
            return 0; 
 
        // When nothing is reachable from the given 0 threshold 
        if (compartmentsArray[startingPoint] == 0) {
            System.out.println("Thesis can not be reached");
            return Integer.MAX_VALUE;
        }
             
        int min = Integer.MAX_VALUE; 
        for (int i = startingPoint + 1; i <= hiddenCompartment && i <= startingPoint + compartmentsArray[startingPoint]; i++) { 
            int jumps = minHops(compartmentsArray, i, hiddenCompartment); 
            if (jumps != Integer.MAX_VALUE && jumps + 1 < min) 
                min = jumps + 1; 
        } 
        return min; 
    } 
  
    public static void main(String args[]) 
    { 
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of compartments: ");
        
    	int numberOfCompartments = input.nextInt();
        
        int compartmentsArray[] = new int[numberOfCompartments];

        System.out.println("Enter all the compartments threshold : ");

        for(int i = 0; i < numberOfCompartments; i++){
            compartmentsArray[i] = input.nextInt();
        }
        
        //startingPoint compartment one is at 0 position in array
        int startingPoint = 0; 
        
        System.out.print("Enter number of Hidden Compartment (starting from 1 to END): ");
    	int hiddenCompartment = input.nextInt() - 1;
    	
        System.out.print("Minimum number of Hops to reach his thesis paper: "
                         + minHops(compartmentsArray, startingPoint, hiddenCompartment)); 
                         
    	
    } 
} 
