public class main {
    public static void main(String[] args) {

        // Note: declared as the interface type, not the concrete class.
        WatchListInterface watchlist = new Watchlist();

        watchlist.addMovie("The Matrix");
        watchlist.addMovie("Spirited Away");
        watchlist.addMovie("Blade Runner");

        // Expected: 3 movies listed, in the order added above
        watchlist.printWatchlist();

        // Expected: replaces index 1 with "Spirited Away (1997)"
        watchlist.updateMovie(1, "Spirited Away (1997)");

        // Expected: removes "The Matrix", returns true
        boolean removed = watchlist.removeMovie("The Matrix");
        System.out.println("Removed The Matrix? " + removed);

        // Expected: 2 movies remaining
        watchlist.printWatchlist();
    }
}
