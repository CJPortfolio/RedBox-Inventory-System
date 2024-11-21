package FileHandling;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Common.BinarySearchTree;
import Common.Movie;


//Class for all file handling
public class Processes {

    //Process the inventory.dat file
    //Format: “<title>”,<quantity available>, <quantity rented>
    public static BinarySearchTree<Movie> processInventory(){
        
        BinarySearchTree<Movie> inventory = new BinarySearchTree<>();

        try 
        {
            BufferedReader inventoryReader = new BufferedReader(new FileReader("C:\\Users\\cjwir\\OneDrive\\Desktop\\Java Programs\\CS 2336\\Projects\\RedBoxInventorySystem\\RedBoxInventorySystem\\src\\main\\java\\FileHandling\\inventory.dat")); 
            String lineToRead = null;

            String Title = null;
            int Available = 0;
            int Rented = 0;
            Movie movie;

            while ((lineToRead = inventoryReader.readLine()) != null) 
            {
                
                String[] data = lineToRead.split(", ");

                Title = data[0].replace("\"","");
                Available = Integer.parseInt(data[1]);
                Rented = Integer.parseInt(data[2]);
                

                movie = new Movie(Title, Available, Rented);

                //System.out.println("Title: " + movie.getTitle() + " Available: " +  movie.getAvailable() + " Rented: " + movie.getRented());

                inventory.insert(movie);
            }
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error with inventory file");
        }
        catch(IOException e)
        {
            System.out.println("Error processing inventory file");
        }

        return inventory;

    }

    //Process transactions in the transaction.log file
    public void processTransactions(){



    }

    //Write the error to the error.log file
    public void writeError(String errorLine){

    }

    //Write the formatted inventory to redbox_kiosk.txt file(refer to project 4 pdf)
    public void writeFormattedInventoryToFile(){

    }
}
