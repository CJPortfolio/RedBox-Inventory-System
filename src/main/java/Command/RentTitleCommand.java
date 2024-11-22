//Student ID: cjw220005
//Name: Christopher Wiratman
package Command;

import Common.MovieInventory;

public class RentTitleCommand extends Command{

    public RentTitleCommand(MovieInventory Inventory, String title, int valueToUse)
    {
        super(Inventory, title, valueToUse);
    }

    @Override
    public void Execute()
    {
        //Decrement available in list
        Inventory.rentDVD(title);

        //Increment rented in list
    }
    
}
