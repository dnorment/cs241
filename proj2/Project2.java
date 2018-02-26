import java.util.Random;
import java.util.Scanner;

/**
 * A driver class for the max heap.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class Project2
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        Random rng = new Random();
        
        System.out.println("=======================================");
        System.out.println("Please select how to test the program:");
        System.out.println("(1) 20 sets of 100 randomly generated integers");
        System.out.println("(2) Fixed integer values 1-100");
        System.out.print("Enter choice: ");
        
        int choice = kb.nextInt();
        MaxHeap heapOne = new MaxHeap();
        MaxHeap heapTwo = new MaxHeap();
        int avg1 = 0;
        int avg2 = 0;
        if (choice == 1)    //20 sets of 100 randomly generated integers
        {
            int swapsOne = 0;
            int swapsTwo = 0;
            for (int i=0; i<20; i++) //20 sets
            {
                for (int j=0; j<100; j++) //add 100 random numbers
                {
                    int rand = rng.nextInt(100000) + 1; //(1,10000)
                    heapOne.add(rand);
                    heapTwo.addLast(rand);
                }
                avg1 += heapOne.getSwapsOne();
                avg2 += heapTwo.getSwapsTwo();
                heapOne.clear();
                heapTwo.clear();
            }
            avg1 = avg1 / 20;
            avg2 = avg2 / 20;
            System.out.println("Average swaps for series of insertions: " + avg1);
            System.out.println("Average swaps for optimal method: " + avg2);
        }
        else //fixed integer values 1-100
        {
            for (int i=1; i<=100; i++) //add 100 random numbers
            {
                heapOne.add(i);
                heapTwo.addLast(i);
            }
            int swap1 = heapOne.getSwapsOne();
            int swap2 = heapTwo.getSwapsTwo();
            Integer[] arrayOne = heapOne.toArray();
            Integer[] arrayTwo = heapTwo.toArray();
            
            String heapBeforeSeries = "";
            String heapAfterSeries = "";
            String heapBeforeOptimal = "";
            String heapAfterOptimal = "";
            for (int i=1; i<=10; i++)
            {
                heapBeforeSeries = heapBeforeSeries + arrayOne[i] + ",";
            }
            for (int i=1; i<=10; i++)
            {
                heapOne.removeMax();
                heapOne.getSwapsTwo();
            }
            for (int i=1; i<=10; i++)
            {
                heapAfterSeries = heapAfterSeries + arrayOne[i] + ",";
            }
            for (int i=1; i<=10; i++)
            {
                heapBeforeOptimal = heapBeforeOptimal + arrayTwo[i] + ",";
            }
            for (int i=1; i<=10; i++)
            {
                heapTwo.removeMax();
                heapTwo.getSwapsTwo();
            }
            for (int i=1; i<=10; i++)
            {
                heapAfterOptimal = heapAfterOptimal + arrayTwo[i] + ",";
            }
            
            System.out.printf("Heap built using series of insertions: %s...%n", heapBeforeSeries);
            System.out.println("Number of swaps: " + swap1);
            System.out.printf("Heap after 10 removals: %s...%n", heapAfterSeries);
            System.out.println();
            System.out.printf("Heap built using optimal method: %s...%n", heapBeforeOptimal);
            System.out.println("Number of swaps: " + swap2);
            System.out.printf("Heap after 10 removals: %s...%n", heapAfterOptimal);
        }

        
    }
}