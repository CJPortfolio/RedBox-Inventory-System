//Student ID: cjw220005
//Name: Christopher Wiratman
package Command;

import Common.BinarySearchTree;
import Common.Movie;

public class RentTitleCommand extends Command{

    public RentTitleCommand(BinarySearchTree<Movie> Inventory)
    {
        super(Inventory);
    }

    @Override
    public void Execute()
    {
        //Decrement available in list

        //Increment rented in list
    }
    
}
