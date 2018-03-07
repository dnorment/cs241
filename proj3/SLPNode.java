
/**
 * A singly linked node that stores a reference to the previous node, stores data, and has a priority. The nodes are comparable by their priority.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class SLPNode<T> implements Comparable<SLPNode<T>>
{
    private SLPNode<T> next;
    private T data;
    private int priority;
    
    public SLPNode()
    {
        next = null;
        data = null;
        priority = 0;
    }
    
    public SLPNode(T newData)
    {
        next = null;
        data = newData;
        priority = 0;
    }
    
    public SLPNode(T newData, int pri)
    {
        next = null;
        data = newData;
        priority = pri;
    }
    
    /** Sets the previous node of this node.
        @param prevNode  The previous node to be set. */
    public void setNext(SLPNode<T> nextNode)
    {
        next = nextNode;
    }
    
    /** Sets the data of this node.
     *  @param newData  The new data to be set. */
    public void setData(T newData)
    {
        data = newData;
    }
    
    /** Gets the previous node from this node.
     *  @return The previous node pointed at by this node. */
    public SLPNode<T> getNext()
    {
        return next;
    }
    
    /** Gets the data from this node.
     *  @return The data in this node. */
    public T getData()
    {
        return data;
    }
    
    public void setPriority(int pri)
    {
        priority = pri;
    }
    
    public int getPriority()
    {
        return priority;
    }
    
    /** Compares data between two nodes.
     *  @param other  The node to which to compare this one.
     *  @return -1, 0, or 1 if the priority of this node is less than, equal to, or greater than the priority of the other node. */
    public int compareTo(SLPNode<T> other)
    {
        if (getPriority() > other.getPriority())
        {
            return -1;
        }
        else if (getPriority() == other.getPriority())
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}
