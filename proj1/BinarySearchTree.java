
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
    
    public BinaryNode<T> findNode(T data)
    {
        BinaryNode<T> node = root;
        while (data.compareTo(node.getData()) != 0) //while data not matching node
        {
            if (data.compareTo(node.getData()) < 0) //data is less than current node
            {
                node = node.getLeftChild();
            }
            else //data is greater than current node
            {
                node = node.getRightChild();
            }
        }
        return node;
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
    
    public BinaryNode<T> removeEntry(BinaryNode<T> node, T data)
    {
        if (node == null) //the parent node is empty (is a leaf). remove parent by setting child to null (node is null)
        {
            return node;
        }
        else //parent has at least 1 child
        {
            if (data.compareTo(node.getData()) < 0) //data less than current node
            {
                node.setLeftChild(removeEntry(node.getLeftChild(), data));
            }
            else if (data.compareTo(node.getData()) > 0) //data greater than current node
            {
                node.setRightChild(removeEntry(node.getRightChild(), data));
            }
            else //data same as current node, so delete this node
            {
                if (node.getLeftChild() == null) //node has no left child, so set to right child
                {
                    return node.getRightChild();
                }
                else if (node.getRightChild() == null) //node has no right child, so set to left child
                {
                    return node.getLeftChild();
                }
                
                BinaryNode<T> current = node; //get successor
                T succ = successor(node.getData());
                node.setData(succ);
                //delete successor
                node.setRightChild(removeEntry(node.getRightChild(), node.getData()));
            }
        }
        return node;
    }
    
    public void remove(T data)
    {
        if (data.compareTo(root.getData()) == 0) //remove root
        {
            if (root.getLeftChild() != null) //root has a left child
            {
                T temp = root.getRightmost(root.getLeftChild()).getData(); //store data of predecessor
                remove(temp);
                root.setData(temp);
            }
            else if (root.getRightChild() != null) //root has a right child, but no left child
            {
                T temp = root.getLeftmost(root.getRightChild()).getData(); //store data of successor
                remove(temp);
                root.setData(temp);
            }
            else //root has no children, so it is the only node
            {
                root.setData(null);
                root = null;
            }
        }
        else //remove node
        {
            removeEntry(root, data);
        }
    }
    
    public BinaryNode<T> findPredecessor(BinaryNode<T> node)
    {
        if (node.getLeftChild() != null)
        {
            return node.getRightmost(node.getLeftChild());
        }
        BinaryNode<T> pred = null;
        BinaryNode<T> current = root;
        while (current != null && node.getData().compareTo(current.getData()) != 0)
        {
            if (node.getData().compareTo(current.getData()) < 0) //node less than current node
            {
                current = current.getLeftChild();
            }
            else //node greater than current node
            {
                pred = current;
                current = current.getRightChild();
            }
        }
        if (pred != null && pred.getLeftChild() != null)
        {
            if (node.getData().compareTo(root.getRightmost(pred.getLeftChild()).getData()) > 0) //node greater than rightmost of left subtree
            {
                return pred;
            }
            else
            {
                return root.getRightmost(pred.getLeftChild());
            }
        }
        else
        {
            return pred;
        }
    }
    
    public T predecessor(T data)
    {
        return findPredecessor(findNode(data)).getData(); //return data of predecessor of node matching data
    }
    
    public BinaryNode<T> findSuccessor(BinaryNode<T> node)
    {
        if (node.getRightChild() != null)
        {
            return node.getLeftmost(node.getRightChild());
        }
        BinaryNode<T> succ = null;
        BinaryNode<T> current = root;
        while (current != null && node.getData().compareTo(current.getData()) != 0)
        {
            if (node.getData().compareTo(current.getData()) > 0) //node greater than current node
            {
                current = current.getRightChild();
            }
            else //node greater than current node
            {
                succ = current;
                current = current.getLeftChild();
            }
        }
        if (succ != null && succ.getRightChild() != null)
        {
            if (node.getData().compareTo(root.getLeftmost(succ.getRightChild()).getData()) > 0) //node greater than leftmost of right subtree
            {
                return succ;
            }
            else
            {
                return root.getLeftmost(succ.getRightChild());
            }
        }
        else
        {
            return succ;
        }
    }
    
    public T successor(T data)
    {
        return findSuccessor(findNode(data)).getData(); //return data of predecessor of node matching data
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