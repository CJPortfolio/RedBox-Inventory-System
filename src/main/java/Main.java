
//Student ID: cjw220005
//Name: Christopher Wiratman

import Common.BinarySearchTree;
import Common.Movie;
import Common.MovieInventory;

public class Main
{
    public static void main(String[] args)
    {
        /*
        //Test

        BinarySearchTree<Movie> bst = new BinarySearchTree<>();

        
        //Mock Data
        bst.insert(new Movie("Inception", 10, 5));
        bst.insert(new Movie("The Matrix", 8, 3));
        bst.insert(new Movie("Interstellar", 12, 2));
        bst.insert(new Movie("Avatar", 15, 7));

        //Test if mock movie exists
        boolean found = bst.search(new Movie("Inception"));
        System.out.println("Is 'Inception' in the  tree? " + found);

        Movie movie = bst.get(new Movie("Inception"));

        System.out.println("Movie: " + movie.getTitle() + " Available: " + movie.getAvailable() + " Rented: " + movie.getRented());

        boolean notFound = bst.search(new Movie("Titanic"));
        System.out.println("Is 'Titanic' in the tree? " + notFound);

        bst.delete(new Movie("Inception"));
        found = bst.search(new Movie("Inception"));
        System.out.println("Is 'Inception' still in the  tree? " + found);

        bst.get(new Movie("Inception"));

        System.out.println("Size: " + bst.size);
        */
        
        //Load inventory.dat file
        BinarySearchTree<Movie> inventory = FileHandling.Processes.processInventory();

        MovieInventory movieInventory = new MovieInventory(inventory);

        //Load and process transaction.log
        FileHandling.Processes.processTransactions(movieInventory);


        //Output final inventory to file
        FileHandling.Processes.writeFormattedInventoryToFile(movieInventory);
    }
}