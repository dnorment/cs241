import java.io.*;
import java.util.Scanner;
/**
 * A driver class for the Digraph using the given data.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class Project3
{
    /**
     * Print out the options for the user to interact with the graph.
     */
    public static void printOptions()
    {
        System.out.println(" Q Query the city information by entering the city code");
        System.out.println(" D Find the minimum distance between two cities");
        System.out.println(" I Insert a road by entering two city codes and distance");
        System.out.println(" R Remove an existing road by entering two city codes");
        System.out.println(" H Display this message");
        System.out.print(" E  Exit");
    }
    
    public static void main(String[] args) throws IOException
    {
        Scanner kb = new Scanner(System.in);
        
        Digraph graph = new Digraph();
        
        String input;
        char cmd = '~';
        String firstCity;
        String secondCity;
        kb = new Scanner(System.in); //Scanner to read command from user
        while(cmd != 'E') //exit when command is E
        {
            System.out.print("Command? ");
            input = kb.nextLine();
            cmd = input.charAt(0);
            Scanner parser = new Scanner(System.in);
            switch(cmd) //parse command
            {
                case 'Q': //query city information given code
                    System.out.print("City code: ");
                    firstCity = parser.next();
                    if (graph.getCity(firstCity) != null)
                    {
                        System.out.print(graph.getCity(firstCity));
                    }
                    else
                    {
                        System.out.print("The city with code " + firstCity + " doesn't exist.");
                    }
                    break;
                case 'D': //find minimum distance between cities
                    System.out.print("City codes: ");
                    firstCity = parser.next();
                    secondCity = parser.next();
                    System.out.print(firstCity + " " + secondCity);                     //TODO
                    break;
                case 'I': //insert a road given 2 cities and distance
                    System.out.print("City codes and distance: ");
                    firstCity = parser.next();
                    secondCity = parser.next();
                    int distance = parser.nextInt();
                    System.out.print(firstCity + " " + secondCity + " " + distance);    //TODO
                    break;
                case 'R': //remove road given 2 city codes
                    System.out.print("City codes: ");
                    firstCity = parser.next();
                    secondCity = parser.next();
                    System.out.print(firstCity + " " + secondCity);                     //TODO
                    break;
                case 'H': //print menu
                    Project3.printOptions();
                    break;
                case 'E': //exit
                    break;
                default: //else, print menu
                    Project3.printOptions();
            }
            System.out.println();
        }
    }
}
