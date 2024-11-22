//Student ID: cjw220005
//Name: Christopher Wiratman
package Common;


public class MovieInventory {
    public static BinarySearchTree<Movie> inventory;

    public MovieInventory(BinarySearchTree<Movie> inventory)
    {
        this.inventory = inventory;
    }

    public void removeDVD(String title, int numberToRemove)
    {
        Movie movie = inventory.get(new Movie(title));
        if(movie.getAvailable() == 0 && movie.getRented() == 0)
        {
            inventory.delete(new Movie(title));
            return;
        }
        else if(movie.getAvailable() < numberToRemove)
        {
            inventory.set(new Movie(movie.getTitle()),new Movie(movie.getTitle(), 0, movie.getRented()));
            return;
        }
        Movie movieToReplace = new Movie(movie.getTitle(), movie.getAvailable() - numberToRemove, movie.getRented());

        inventory.set(movie, movieToReplace);
    }

    public void addDVD(String title, int numberToAdd)
    {
        Movie movie = inventory.get(new Movie(title));
        Movie movieToReplace = new Movie(movie.getTitle(), movie.getAvailable() + numberToAdd, movie.getRented());

        inventory.set(movie, movieToReplace);

    }

    public void rentDVD(String title)
    {
        Movie movie = inventory.get(new Movie(title));
        Movie movieToReplace = new Movie(movie.getTitle(), movie.getAvailable() - 1, movie.getRented() + 1);
        inventory.set(movie, movieToReplace);
    }

    public void returnDVD(String title)
    {
        Movie movie = inventory.get(new Movie(title));
        Movie movieToReplace = new Movie(movie.getTitle(), movie.getAvailable() + 1, movie.getRented() - 1);
        inventory.set(movie, movieToReplace);
    }
}
