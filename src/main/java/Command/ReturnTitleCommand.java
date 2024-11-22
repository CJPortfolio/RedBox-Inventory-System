//Student ID: cjw220005
//Name: Christopher Wiratman
package Command;

import Common.MovieInventory;

public class ReturnTitleCommand extends Command{

    public ReturnTitleCommand(MovieInventory Inventory, String title, int valueToUse)
    {
        super(Inventory, title, valueToUse);
    }


    @Override
    public void Execute()
    {
        //Increment available in list
        //Decrement rented in list
        
        Inventory.returnDVD(title);

        
    }
    
}
