//Student ID: cjw220005
//Name: Christopher Wiratman
package Command;

import Common.BinarySearchTree;
import Common.Movie;

public abstract class Command {

    BinarySearchTree<Movie> Inventory;
    
    public Command(BinarySearchTree<Movie> Inventory)
    {
        this.Inventory = Inventory;
    }
    

    public abstract void Execute();
}
