//Student ID: cjw220005
//Name: Christopher Wiratman
package Common;

public class Movie implements Comparable<Movie>{
    String Title;
    int Available;
    int Rented;

    //Overloaded constructor to create class with data
    public Movie(String Title, int Available, int Rented)
    {
        this.Title = Title;
        this.Available = Available;
        this.Rented = Rented;
    }

    public Movie(String Title)
    {
        this.Title = Title;
        this.Available = 0;
        this.Rented = 0;
    }

    //Mutators
    public String getTitle() {
        return this.Title;
    }

    public int getAvailable()
    {
        return this.Available;
    }

    public int getRented()
    {
        return this.Rented;
    }

    //Accessors
    public void setTitle(String Title)
    {
        this.Title = Title;
    }

    public void setAvailable(int Available)
    {
        this.Available = Available;
    }

    public void setRented(int Rented)
    {
        this.Rented = Rented;
    }

    @Override
    public int compareTo(Movie other){
        return this.Title.compareTo(other.Title);
    }
    
}
