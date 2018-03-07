
/**
 * An implementation of the ADT Priority Queue using singly linked data. 
 *
 * @author Daniel J. Norment
 * @version 1.1
 */
public class PriorityQueueSingleLinked<T>
{
    private SLPNode<T> head;
    private SLPNode<T> tail;
    private int nodes;
    
    public PriorityQueueSingleLinked()
    {
        head = null;
        tail = null;
        nodes = 0;
    }
    
    /** Adds a new entry to the end of this priority queue.
       @param newEntry  An object to be added. */
    public void add(T newEntry)
    {
       add(newEntry, 0); //default to priority 0
    }
    
    /** Adds a new entry to this priority queue with a certain priority.
     * Calls add(int, T) to insert at correct priority's position.
     * @param newEntry  An object to be added.
     * @param pri  The priority of the object to be added (>=0). */
    public void add(T newEntry, int pri)
    {
       SLPNode<T> newNode = new SLPNode<T>(newEntry, pri);
       if (isEmpty())
       {
           head = newNode;
           tail = newNode;
       }
       else if (nodes == 1)
       {
           if (newNode.compareTo(tail) > 0) //newNode more important
           {
               tail.setNext(newNode);
               head = newNode;
           }
           else
           {
               newNode.setNext(tail);
               tail = newNode;
           }
       }
       else
       {
           SLPNode<T> beforeNode = tail;
           while (beforeNode.getNext() != null && beforeNode.getNext().compareTo(newNode) < 0)
           {
               beforeNode = beforeNode.getNext();
           }
           if (beforeNode.getNext() == null) //newNode most important
           {
               beforeNode.setNext(newNode);
               head = newNode;
           }
           else if (newNode.compareTo(tail) < 0) //newNode least important
           {
               newNode.setNext(tail);
               tail = newNode;
           }
           else //goes in middle somewhere
           {
               newNode.setNext(beforeNode.getNext());
               beforeNode.setNext(newNode);
           }
       }
       nodes++;
    }

    /** Removes and returns the entry having the highest priority.
       @return  Either the object having the highest priority or,
                if the priority queue is empty before the operation, null. */
    public T remove()
    {
       if (isEmpty())
       {
           return null;
       }
       else if (nodes == 1)
       {
           T temp = head.getData();
           clear();
           return temp;
       }
       else
       {
           SLPNode<T> beforeNode = tail;
           while (beforeNode.getNext() != head) //beforeNode -> new head
           {
               beforeNode = beforeNode.getNext();
           }
           T temp = head.getData();
           head.setData(null);
           beforeNode.setNext(null);
           head = beforeNode;
           nodes--;
           return temp;
       }
    }

    /** Retrieves the entry having the highest priority.
       @return  Either the object having the highest priority or,
                if the priority queue is empty, null. */
    public T peek()
    {
       if (isEmpty())
       {
           return null;
       }
       else
       {
           return head.getData();
       }
    }

    /** Detects whether this priority queue is empty.
       @return  True if the priority queue is empty, or false otherwise. */
    public boolean isEmpty()
    {
       return head == null && tail == null;
    }

    /** Gets the size of this priority queue.
       @return  The number of entries currently in the priority queue. */
    public int getSize()
    {
       return nodes;
    }

    /** Removes all entries from this priority queue. */
    public void clear()
    {
       if (!isEmpty())
       {
           SLPNode<T> lastNode = tail;
           while (lastNode.getNext() != null)
           {
               lastNode.setData(null);
               lastNode.setPriority(-1);
               SLPNode<T> nextNode = lastNode.getNext();
               lastNode.setNext(null);
               lastNode = nextNode;
           }
           head.setData(null);
           head.setPriority(-1);
           head.setNext(null);
           head = null;
           tail = null;
           nodes = 0;
       }
    }
}
