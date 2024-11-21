//Student ID: cjw220005
//Name: Christopher Wiratman
package Command;

import Common.BinarySearchTree;
import Common.Movie;

public class ReturnTitleCommand extends Command{

    public ReturnTitleCommand(BinarySearchTree<Movie> Inventory)
    {
        super(Inventory);
    }


    @Override
    public void Execute()
    {
        //Increment available in list
        
        //Decrement rented in list
    }
    
}
