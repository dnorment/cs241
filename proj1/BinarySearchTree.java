
/**
 * An implementation of a binary search tree using nodes with references to child node(s).
 * 
 * @author Daniel J. Norment
 * @version 1.0
 */
public class BinarySearchTree<T extends Comparable<? super T>>
{   
    BinaryNode<T> root;
    
    public BinarySearchTree()
    {
        root = null;
    }
    
    public BinarySearchTree(BinaryNode<T> root)
    {
        this.root = root;
    }
    
    public T findEntry(BinaryNode<T> node, T data)
    {
        T entry = null;
        if (node != null)
        {
            if (data.compareTo(node.getData()) == 0)
            {
                entry = node.getData();
            }
            else if (data.compareTo(node.getData()) < 0)
            {
                entry = findEntry(node.getLeftChild(), data);
            }
            else
            {
                entry = findEntry(node.getRightChild(), data);
            }
        }
        return entry;
    }
    
    public T getEntry(T data)
    {
        return findEntry(root, data);
    }
    
    public boolean contains(T data)
    {
        return getEntry(data) != null;
    }
    
    public void addEntry(BinaryNode<T> node, T data)
    {
        if (data.compareTo(node.getData()) == 0) //data is same as data in current node
        {
            //this will never execute, will handle duplicate data in add()
        }
        else if (data.compareTo(node.getData()) < 0) //data is less than data in current node
        {
            if (node.getLeftChild() != null) //node has a left child
            {
                addEntry(node.getLeftChild(), data); //addEntry to left child
            }
            else //node doesn't have a left child
            {
                node.setLeftChild(new BinaryNode<T>(data)); //set left child to node w/ new data
            }
        }
        else //(data.compareTo(node.getData()) > 0) //data is greater than data in current node
        {
            if (node.getRightChild() != null) //node has a right child
            {
                addEntry(node.getRightChild(), data); //addEntry to right child
            }
            else //node doesn't have a right child
            {
                node.setRightChild(new BinaryNode<T>(data)); //set right child to node w/ new data
            }
        }
    }
    
    public void add(T data)
    {
        if (root == null) //tree is empty
        {
            root = new BinaryNode<T>(data); //set tree to node w/ new data
        }
        else //tree not empty
        {
            addEntry(root, data); //add node to tree
        }
    }
    
    public T remove(T data)
    {
        if (contains(data))
        {
            return null;
        }
        else
        {
            return null;
        }
    }
    
    public void printPreOrder()
    {
        preOrder(root);
    }
    
    public void printInOrder()
    {
        inOrder(root);
    }
    
    public void printPostOrder()
    {
        postOrder(root);
    }
    
    public void preOrder(BinaryNode<T> node)
    {
        if (node != null)
        {
            System.out.print(node.getData() + " ");
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }
    
    public void inOrder(BinaryNode<T> node)
    {
        if (node != null)
        {
            inOrder(node.getLeftChild());
            System.out.print(node.getData() + " ");
            inOrder(node.getRightChild());
        }
    }
    
    public void postOrder(BinaryNode<T> node)
    {
        if (node != null)
        {
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            System.out.print(node.getData() + " ");
        }
    }
}