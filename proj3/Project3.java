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
        String firstCity, secondCity;
        City fromCity, toCity;
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
                    fromCity = graph.getCity(firstCity);
                    if (fromCity != null)
                    {
                        System.out.print(fromCity);
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
                    fromCity = graph.getCity(firstCity);
                    toCity = graph.getCity(secondCity);
                    
                    break;
                case 'I': //insert a road given 2 cities and distance
                    System.out.print("City codes and distance: ");
                    firstCity = parser.next();
                    secondCity = parser.next();
                    int distance = parser.nextInt();
                    graph.insertRoad(graph.getCity(firstCity), graph.getCity(secondCity), distance);
                    System.out.printf("You have inserted a road from %s to %s with a distance of %d.",
                                    graph.getCity(firstCity).getCityName(), graph.getCity(secondCity).getCityName(), distance);
                    break;
                case 'R': //remove road given 2 city codes
                    System.out.print("City codes: ");
                    firstCity = parser.next();
                    secondCity = parser.next();
                    fromCity = graph.getCity(firstCity);
                    toCity = graph.getCity(secondCity);
                    if (fromCity == null)
                    {
                        System.out.print("The city with code " + firstCity + " doesn't exist.");
                    }
                    else if (toCity == null)
                    {
                        System.out.print("The city with code " + secondCity + " doesn't exist.");
                    }
                    else
                    {
                        boolean removed = graph.removeRoad(fromCity, toCity);
                        if (removed)
                        {
                            System.out.printf("The road from %s to %s was removed.", fromCity.getCityName(), toCity.getCityName());
                        }
                        else
                        {
                            System.out.printf("The road from %s to %s doesn't exist.", fromCity.getCityName(), toCity.getCityName());
                        }
                    }
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
