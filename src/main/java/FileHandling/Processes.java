//Student ID: cjw220005
//Name: Christopher Wiratman
package FileHandling;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Command.AddTitleCommand;
import Command.Command;
import Command.RemoveTitleCommand;
import Command.RentTitleCommand;
import Command.ReturnTitleCommand;
import Common.BinarySearchTree;
import Common.Movie;
import Common.MovieInventory;


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


            inventoryReader.close();
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
    public static void processTransactions(MovieInventory inventory){

        try 
        {
            BufferedReader inventoryReader = new BufferedReader(new FileReader("C:\\Users\\cjwir\\OneDrive\\Desktop\\Java Programs\\CS 2336\\Projects\\RedBoxInventorySystem\\RedBoxInventorySystem\\src\\main\\java\\FileHandling\\inventory.dat")); 
            Pattern movieTitlePattern = Pattern.compile("\"([^\"]*)\"");
            String lineToRead = null;
            String commandName = null;
            String movieTitle = null;
            int valueToUse;
            Command command;

            while ((lineToRead = inventoryReader.readLine()) != null) 
            { 
                if(validateTransaction(lineToRead))
                {
                    //Process formatted line

                    //Get the command name
                    String[] data = lineToRead.split("\\s+");
                    commandName = data[0].toLowerCase();
                    Matcher matchedQuote = movieTitlePattern.matcher(lineToRead);

                    

                    //TODO:  Depending on the first word, parse the data accordingly
                    
                    switch(commandName)
                    {
                        case "add":
                        
                        //Get the title in the line
                        
                        while(matchedQuote.find()){
                            movieTitle = matchedQuote.group(1).replace("\"","");
                        }

                        //Get the value for adding or removing from the line
                        data = lineToRead.split(",");
                        data[1].trim();

                        valueToUse = Integer.parseInt(data[1]);

                        command = new AddTitleCommand(inventory, movieTitle, valueToUse);
                        command.Execute();

                            break;

                        case "remove":

                        //Get the title in the line
                        while(matchedQuote.find()){
                            movieTitle = matchedQuote.group(1).replace("\"","");
                        }

                        //Get the value for adding or removing from the line
                        data = lineToRead.split(",");
                        data[1].trim();

                        valueToUse = Integer.parseInt(data[1]);

                        command = new RemoveTitleCommand(inventory, movieTitle, valueToUse);
                        command.Execute();

                            break;

                        case "rent":

                        movieTitle = data[1].replace("\"","");
                        command = new RentTitleCommand(inventory, movieTitle, 0);
                        command.Execute();

                            break;

                        case "return":

                        movieTitle = data[1].replace("\"","");
                        command = new ReturnTitleCommand(inventory, movieTitle, 0);
                        command.Execute();

                            break;
                    }

                }
                else
                {
                    writeError(lineToRead);
                }
                               
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
                
    }
                
                    
                    
    public static Boolean validateTransaction(String lineToRead)
    {
        String addRegex = "(?i)^add\\s+\"[^\"]+\"\\s*,\\s*\\d+$";
        String removeRegex = "(?i)^remove\\s+\"[^\"]+\"\\s*,\\s*\\d+$";
        String rentRegex = "(?i)^rent\\s+\"[^\"]+\"$";
        String returnRegex = "(?i)^return\\s+\"[^\"]+\"$";

        return lineToRead.matches(addRegex) || lineToRead.matches(removeRegex)
            || lineToRead.matches(rentRegex) || lineToRead.matches(returnRegex);
    }

    //Write the error to the error.log file
    public static void writeError(String errorLine){
        try
        {
            BufferedWriter errorWriter = new BufferedWriter(new FileWriter("C:\\Users\\cjwir\\OneDrive\\Desktop\\Java Programs\\CS 2336\\Projects\\RedBoxInventorySystem\\RedBoxInventorySystem\\src\\main\\java\\FileHandling\\error.log"));
            errorWriter.write(errorLine + System.lineSeparator());
            errorWriter.close();
        }
        catch(IOException e)
        {
            System.out.println("Error writing to error log file");
        }
    }

    //Write the formatted inventory to redbox_kiosk.txt file(refer to project 4 pdf)
    public static void writeFormattedInventoryToFile(MovieInventory Inventory){

        try
        {
            BufferedWriter formatWriter = new BufferedWriter(new FileWriter("C:\\Users\\cjwir\\OneDrive\\Desktop\\Java Programs\\CS 2336\\Projects\\RedBoxInventorySystem\\RedBoxInventorySystem\\src\\main\\java\\FileHandling\\redbox_kiosk.txt"));
            String header = String.format("%-20s%-14s%-8s%n", "Title", "Available", "Rented" );
            header += "----------------------------------------";

            formatWriter.write(header);

            Movie[] dataToWrite = new Movie[Inventory.inventory.size];
            
            Movie movieToReport = Inventory.inventory.get(new Movie(header));
            formatWriter.close();

        }
        catch(IOException e)
        {
            System.out.println("Error writing to error log file");
        }

    }
}
