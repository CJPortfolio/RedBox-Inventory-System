//Student ID: cjw220005
//Name: Christopher Wiratmans
package Command;

import Common.MovieInventory;

public class RemoveTitleCommand extends Command{


    public RemoveTitleCommand(MovieInventory Inventory, String title, int valueToUse)
    {
        super(Inventory, title, valueToUse);
    }


    @Override
    public void Execute()
    {
        //If copies removed are more than available set availability to zero
            //Remove title availability from list by value in file
        //If availability is zero and no copies are rented
            //delete node from tree

        Inventory.removeDVD(title, valueToUse);

    }
    
}
