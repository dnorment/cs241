
/**
 * An implementation of the max heap with integers using an array.
 *
 * @author Daniel J. Norment
 * @version 1.0
 */
public class MaxHeap
{
    private Integer[] heap;
    private int lastIndex;
    private int numItems;
    private int swapsAdd;
    private int swapsReheap;
    
    public MaxHeap()
    {
        this(150);
    }
    
    public MaxHeap(int size)
    {
       heap = new Integer[size];
       lastIndex = 0;
       numItems = 0;
       swapsAdd = 0;
       swapsReheap = 0;
    }
    
    /**
     * Performs the reheap operation on the given index.
     * @param index  The index at which to perform the reheap operation.
     */
    public void reheap(int index)
    {
       boolean done = false;
       int orphan = heap[index];
       int leftChildIndex = 2 * index;
       while (!done && leftChildIndex <= lastIndex)
       {
           int largerChildIndex = leftChildIndex;
           int rightChildIndex = leftChildIndex + 1;
           if (rightChildIndex <= lastIndex && heap[rightChildIndex] > heap[largerChildIndex])
           {
              largerChildIndex = rightChildIndex;
           }
           if (orphan < heap[largerChildIndex])
           {
               heap[index] = heap[largerChildIndex];
               swapsReheap++;
               index = largerChildIndex;
               leftChildIndex = 2 * index;
           }
           else
           {
               done = true;
           }
       }
       heap[index] = orphan;
    }
    
    /**
     * Adds the given item into the heap.
     * @param item  The data value to add into the heap.
     */
    public void add(int item)
    {
        if (isEmpty())
        {
            heap[1] = item;
        }
        else
        {
            int newIndex = lastIndex + 1;
            int parentIndex = newIndex / 2;
            while (parentIndex > 0 && item > heap[parentIndex])
            {
                heap[newIndex] = heap[parentIndex];
                swapsAdd++;
                newIndex = parentIndex;
                parentIndex = newIndex / 2;
            }
            heap[newIndex] = item;
            lastIndex++;
        }
    }
    
    /**
     * Adds the value to the end of the array, not preserving the heap structure.
     * @param item  The data value to add into the array.
     */
    public void addLast(int item)
    {
        heap[++lastIndex] = item;
    }
    
    /**
     * Removes the value at the root of the maxheap.
     * @return  The value that was removed.
     */
    public int removeMax()
    {
        Integer root = null;
        if (!isEmpty())
        {
            root = heap[1];
            heap[1] = heap[lastIndex];
            heap[lastIndex--] = null;
            reheap(1);
        }
        return root;
    }
    
    /**
     * Returns the value at the root of the maxheap.
     * @return  The value that is at the root.
     */
    public int getMax()
    {
        return heap[1];
    }
    
    /**
     * Returns whether the maxheap is empty.
     * @return  True if the maxheap has no values.
     */
    public boolean isEmpty()
    {
        return heap[1] == null;
    }
    
    /**
     * Returns the size of the maxheap.
     * @return  The number of items in the maxheap.
     */
    public int getSize()
    {
        return numItems;
    }
    
    /**
     * Deletes all values in the maxheap.
     */
    public void clear()
    {
        for (int i = 0; i < heap.length; i++)
        {
            heap[i] = null;
        }
        lastIndex = 0;
        numItems = 0;
        swapsAdd = 0;
        swapsReheap = 0;
    }
    
    /**
     * Returns the array that the heap uses.
     * @return  The array that the heap uses.
     */
    public Integer[] toArray()
    {
        return heap;
    }
    
    /**
     * Returns the number of swaps when adding normally.
     * @return  The number of swaps when adding normally.
     */
    public int getSwapsOne()
    {
        return swapsAdd;
    }
    
    /**
     * Returns the number of swaps when adding optimally.
     * @return  The number of swaps when adding optimally. 
     */
    public int getSwapsTwo()
    {
        int lastNLN = lastIndex / 2;
        while (lastNLN > 0)
        {
            reheap(lastNLN--);
        }
        return swapsReheap;
    }
}
