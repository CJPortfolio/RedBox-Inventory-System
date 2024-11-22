//Student ID: cjw220005
//Name: Christopher Wiratman
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import Command.AddTitleCommand;
import Command.Command;
import Command.RemoveTitleCommand;
import Command.RentTitleCommand;
import Command.ReturnTitleCommand;
import Common.BinarySearchTree;
import Common.Movie;
import Common.MovieInventory;

public class UnitTests {

    

    @Test
    public void testAddTitle()
    {
        //Mock Data
        BinarySearchTree<Movie> mockData = new BinarySearchTree<>();
        Movie movie = new Movie("The Titanic");
        mockData.insert(movie);
        MovieInventory inventory = new MovieInventory(mockData);


        //Add Title Command
        Command command = new AddTitleCommand(inventory, "The Titanic", 10);
        command.Execute();
        
        assertTrue(inventory.inventory.search(movie));
  
    }

    @Test
    public void testRemoveTitle()
    {
        //Mock Data
        BinarySearchTree<Movie> mockData = new BinarySearchTree<>();
        Movie movie = new Movie("The Titanic");
        mockData.insert(movie);
        MovieInventory inventory = new MovieInventory(mockData);


        //Remove Title Command
        Command command = new RemoveTitleCommand(inventory, "The Titanic", 0);
        command.Execute();
        assertTrue(!inventory.inventory.search(movie));
    }
    
    @Test
    public void testRentTitle()
    {
        //Mock Data
        BinarySearchTree<Movie> mockData = new BinarySearchTree<>();
        Movie movie = new Movie("The Titanic", 10, 20);
        mockData.insert(movie);
        MovieInventory inventory = new MovieInventory(mockData);


        //Rent Title Command
        Command command = new RentTitleCommand(inventory, "The Titanic", 0);
        command.Execute();
        assertTrue(inventory.inventory.get(movie).getAvailable() == 9 && inventory.inventory.get(movie).getRented() == 21);
    }

    @Test
    public void testReturnTitle()
    {

        //Mock Data
        BinarySearchTree<Movie> mockData = new BinarySearchTree<>();
        Movie movie = new Movie("The Titanic", 10, 20);
        mockData.insert(movie);
        MovieInventory inventory = new MovieInventory(mockData);


        //Return Title Command
        Command command = new ReturnTitleCommand(inventory, "The Titanic", 0);
        command.Execute();
        assertTrue(inventory.inventory.get(movie).getAvailable() == 11 && inventory.inventory.get(movie).getRented() == 19);
        
    }
}
