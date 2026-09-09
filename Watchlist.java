import java.util.List;
import java.util.ArrayList;

public class Watchlist implements WatchListInterface{
    private ArrayList<String> movies;

    public  Watchlist(){
        movies = new ArrayList<String>();
    }

    public void addMovie(String title){
        movies.add(title);
    }

    public boolean removeMovie(String title) {
        return movies.remove(title);
    }

    public void updateMovie(int index, String newTitle){
        movies.set(index, newTitle);
    }

    public String getMovie(int index){
        return movies.get(index);
    }

    public int getSize(){
        return movies.size();
    }

    public void printWatchlist(){
        for(int i = 0; i < getSize(); i++ ){
            System.out.print(movies.get(i) + " " );
        }
    }
}
