
/**
 * An object containing both data and a reference to the left and right child nodes.
 * 
 * @author Daniel J. Norment
 * @version 1.0
 */
public class BinaryNode<T>
{
    private T data;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;

    public BinaryNode()
    {
        data = null;
        leftChild = rightChild = null;
    }
    
    public BinaryNode(T info)
    {
        data = info;
        leftChild = rightChild = null;
    }
    
    public BinaryNode(T info, BinaryNode<T> leftNode, BinaryNode<T> rightNode)
    {
        data = info;
        leftChild = leftNode;
        rightChild = rightNode;
    }
    
    /**
     * Returns the data in the BinaryNode.
     * @return  The data contained in the BinaryNode.
     */
    public T getData()
    {
        return data;
    }
    
    /**
     * Returns the BinaryNode that is the left child of this BinaryNode.
     * @return  The BinaryNode that is the left child of this BinaryNode.
     */
    public BinaryNode<T> getLeftChild()
    {
        return leftChild;
    }
    
    /**
     * Returns the BinaryNode that is the right child of this BinaryNode.
     * @return  The BinaryNode that is the right child of this BinaryNode.
     */
    public BinaryNode<T> getRightChild()
    {
        return rightChild;
    }
    
    /**
     * Sets the data in the BinaryNode.
     * @param info  The data to be set.
     */
    public void setData(T info)
    {
        data = info;
    }
    
    /**
     * Sets the left child of this BinaryNode.
     * @param nextBinaryNode  The BinaryNode to be set as the left child of this BinaryNode.
     */
    public void setLeftChild(BinaryNode<T> leftBinaryNode)
    {
        leftChild = leftBinaryNode;
    }
    
    /**
     * Sets the right child of this BinaryNode.
     * @param nextBinaryNode  The BinaryNode to be set as the right child of this BinaryNode.
     */
    public void setRightChild(BinaryNode<T> rightBinaryNode)
    {
        rightChild = rightBinaryNode;
    }
}
