//Student ID: cjw220005
//Name: Christopher Wiratman
package Common;

class Node<E>
{
    E data;

    Node<E> Left;
    Node<E> Right;

    //Overloaded Constructor
    public Node(E element)
    {
        this.data = element;
        this.Left = null;
        this.Right = null;
    }

    public E getData()
    {
        return this.data;
    }

    public Node<E> getLeft()
    {
        return this.Left;
    }

    public Node<E> getRight()
    {
        return this.Right;
    }

    public void setData(E element)
    {
        this.data = element;
    }

    public void setLeft(Node<E> element)
    {
        this.Left = element;

    }

    public void setRight(Node<E> element)
    {
        this.Right = element;
    }

}   

public class BinarySearchTree <E extends Comparable<E>> {

    Node<E> root;
    public int size;

    public BinarySearchTree()
    {
        root = null;
        size = 0;
    }

    public E get(E key)
    {
        Node<E> current = root;
        int compareResult;
         
        //Traverses until it reaches a null node
        while(current != null)
        {
            compareResult = key.compareTo(current.data);
            //Returns current node's data if it's a match
            if(compareResult == 0)
            {
                return current.data;
            }
            //Traverse left subtree
            else if(compareResult < 0)
            {
                current = current.Left;
            }
            //Traverse right subtree
            else if(compareResult > 0)
            {
                current = current.Right;
            }
        }

        //If unable to get, returns null
        return null;
    }

    public void set(E key, E newData)
    {
        Node<E> current = root;

        int compareResult;
        
        //Traverses until reaching a null node
        while(current != null)
        {
            compareResult = key.compareTo(current.data);

            //Sets to new data if key is found
            if (compareResult == 0)
            {
                current.data = newData;
                return;
            }
            //Traverses to left of subtree
            else if(compareResult < 0)
            {
                current = current.Left;
            }
            //Traverses to right of subtree
            else if(compareResult > 0)
            {
                current = current.Right;
            }
            
        }
        //If key could not be found to set new data,
        //sets a prompt that element in tree could not be found
        System.out.println("Element could not be found");
    }


    public void insert(E value)
    {
        //Calls function to insert the root value
        root = insertRecursion(root, value);
        ++size;
    }

    private Node<E> insertRecursion(Node<E> current, E value)
    {
        //Base case if the current node is null
        if(current == null)
        {
            return new Node<>(value);
        }

        //Get result of comparison
        int compareResult = value.compareTo(current.getData());
        //If less than current node data insert to left subtree of current node
        if(compareResult < 0)
        {
            current.setLeft(insertRecursion(current.getLeft(), value));
        }
        //If greater than current node data insert to right subtree of current node
        else if(compareResult > 0)
        {
            current.setRight(insertRecursion(current.getRight(), value));
        }
        return current;
    }



    public boolean search(E element)
    {
        return searchRecursion(root, element);
    }

    private boolean searchRecursion(Node<E> current, E key)
    {
        //Base case if the node is empty or null
        if(current == null){
            return false;
        }

        //Get result of comparison
        int compareResult = key.compareTo(current.getData());
        
        //Traverses to the left of the subtree if comparing result is less than key
        if (compareResult < 0) {
            return searchRecursion(current.getLeft(), key);
        } 
        //Traverses to the right of the subtree if comparing result is greater than key
        else if (compareResult > 0) 
        {
            return searchRecursion(current.getRight(), key);
        } 
        else 
        {
            return true;
        }

    }

    //TODO: Implement delete
    public void delete(E value)
    {
        //Calls recursion function for deletion
        root = deleteRecursion(root, value);
        --size;
    }

    private Node<E> deleteRecursion(Node<E> current, E key)
    {
        //Base case if the node is empty or is null
        if(current == null)
        {
            return null;
        }

        //Gets the result of the current node compared to the key
        int compareResult = key.compareTo(current.getData());

        //Traverses towards the left subtree
        if(compareResult < 0)
        {
            current.Left = deleteRecursion(current.Left, key);
        }
        //Traverses towards the right subtree
        else if(compareResult > 0)
        {
            current.Right = deleteRecursion(current.Right, key);
        }
        //Handles replacing the node to delete with an available child node
        else
        {
            if(current.Left == null && current.Right == null)
            {
                return null;
            }
            else if(current.Left == null) 
            {
                return current.Right;
            }
            else if(current.Right == null)
            {
                return current.Left;
            }
            else
            {
                Node<E> minimumNode = findMin(current.Right);
                current.data = (minimumNode.data);
                current.Right = deleteRecursion(current.Right, minimumNode.data);
            }
        }

        return current;
    }

    private Node<E> findMin(Node<E> current)
    {
        while(current.Left != null)
        {
            current = current.Left;
        }
        return current;
    }

    
}
