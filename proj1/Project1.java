import java.util.Scanner;
/**
 * A driver class for the BST using integers.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class Project1
{
    public static void printOptions()
    {
        System.out.println(" I  Insert a value");
        System.out.println(" D  Delete a value");
        System.out.println(" P  Find predecessor");
        System.out.println(" S  Find successor");
        System.out.println(" E  Exit the program");
        System.out.print(" H  Display this message");
    }
    
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        
        System.out.println("Please enter the initial sequence of values:");
        String input = kb.nextLine();
        kb = new Scanner(input);
        while (kb.hasNextInt())
        {
            bst.add(kb.nextInt());
        }
        
        System.out.print("Pre-order: ");
        bst.printPreOrder();
        System.out.printf("%nIn-order: ");
        bst.printInOrder();
        System.out.printf("%nPost-order: ");
        bst.printPostOrder();
        System.out.println();
        
        char cmd = '~';
        kb = new Scanner(System.in);
        while(cmd != 'E')
        {
            System.out.print("Command? ");
            input = kb.nextLine();
            cmd = input.charAt(0);
            int value;
            switch(cmd)
            {
                case 'I': //insert value
                    value = Integer.parseInt(input.substring(2));
                    if (bst.contains(value))
                    {
                        System.out.printf("%d already exists, ignore.", value);
                    }
                    else
                    {
                        bst.add(value);
                        System.out.print("In-order: ");
                        bst.printInOrder();
                    }
                    break;
                case 'D': //delete value
                    value = Integer.parseInt(input.substring(2));
                    if (bst.contains(value))
                    {
                        bst.remove(value);
                        System.out.print("In-order: ");
                        bst.printInOrder();
                    }
                    else
                    {
                        System.out.printf("%d doesn't exist!", value);
                    }
                    break;
                case 'P': //find predecessor
                    value = Integer.parseInt(input.substring(2));
                    if (bst.contains(value))
                    {
                        try
                        {
                            System.out.print(bst.predecessor(value));
                        }
                        catch (NullPointerException e)
                        {
                            System.out.printf("%d is the first value in order", value);
                        }
                    }
                    else
                    {
                        System.out.printf("%d doesn't exist!", value);
                    }
                    break;
                case 'S': //find successor
                    value = Integer.parseInt(input.substring(2));
                    if (bst.contains(value))
                    {
                        try
                        {
                            System.out.print(bst.successor(value));
                        }
                        catch (NullPointerException e)
                        {
                            System.out.printf("%d is the last value in order", value);
                        }
                    }
                    else
                    {
                        System.out.printf("%d doesn't exist!", value);
                    }
                    break;
                case 'E': //exit
                    break;
                case 'H': //print menu
                    Project1.printOptions();
                    break;
                default:
                    Project1.printOptions();
            }
            System.out.println();
        }
        System.out.print("Thank you for using my program!");
    }
}
