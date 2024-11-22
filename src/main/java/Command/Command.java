//Student ID: cjw220005
//Name: Christopher Wiratman
package Command;

import Common.MovieInventory;

public abstract class Command {


    MovieInventory Inventory;
    String title;
    int valueToUse;
    
    public Command(MovieInventory Inventory, String title, int valueToUse)
    {
        this.Inventory = Inventory;
        this.title = title;
        this.valueToUse = valueToUse;
    }

    /*
    public static Command dynamicallyCreateCommand(BinarySearchTree<Movie> Inventory, String commandName)
    {
        Class<?> concreteCommandClass = null;
        Command command = null;
        String packageName = "Command";
        String commandLabel = "TitleCommand";

        try
        {
            concreteCommandClass = Class.forName(packageName + "." + commandName + commandLabel);
            Constructor<?> constructor = concreteCommandClass.getConstructor(BinarySearchTree.class);
            command = (Command)constructor.newInstance(Inventory, );
        }
        catch(final Exception e)
        {
            e.printStackTrace();
        }

        return command;
    }
    */

    public abstract void Execute();
}
