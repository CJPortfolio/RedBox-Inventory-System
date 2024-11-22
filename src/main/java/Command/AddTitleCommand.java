//Student ID: cjw220005
//Name: Christopher Wiratman
package Command;

import Common.Movie;
import Common.MovieInventory;

public class AddTitleCommand extends Command{

    public AddTitleCommand(MovieInventory Inventory, String title, int valueToUse)
    {
        super(Inventory, title, valueToUse);
    }
    

    @Override
    public void Execute()
    {
        
        //Check if movie exists in list

        if(Inventory.inventory.search(new Movie(title)) != true)
        {
            //If movie doesn't exist
                //Add a movie to the list
            Inventory.inventory.insert(new Movie(title, valueToUse, 0));
        }
        else
        {
            //if movie does exist
                //Increase availability 
            Inventory.addDVD(title, valueToUse);
        }

    }
}
