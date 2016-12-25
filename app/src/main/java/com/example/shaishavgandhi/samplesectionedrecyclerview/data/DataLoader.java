package com.example.shaishavgandhi.samplesectionedrecyclerview.data;

import com.example.shaishavgandhi.samplesectionedrecyclerview.data.models.Book;
import com.example.shaishavgandhi.samplesectionedrecyclerview.data.models.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaishav.gandhi on 12/24/16.
 */

public class DataLoader {

    public static List<Movie> loadMovies() {
        List<Movie> mMovies = new ArrayList<>();
        Movie movie = new Movie();
        movie.setTitle("The Godfather");
        movie.setDescription("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
        movie.setPoster("http://ia.media-imdb.com/images/M/MV5BMTY5OTE4MDM5N15BMl5BanBnXkFtZTcwNDAyMDg0Nw@@._V1_CR0,60,640,360_AL_UX477_CR0,0,477,268_AL_.jpg");

        Movie movie1 = new Movie();
        movie1.setTitle("The Shawshank Redemption");
        movie1.setDescription("Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.");
        movie1.setPoster("http://ia.media-imdb.com/images/M/MV5BNjQ2NDA3MDcxMF5BMl5BanBnXkFtZTgwMjE5NTU0NzE@._V1_CR0,60,640,360_AL_UX477_CR0,0,477,268_AL_.jpg");

        Movie movie2 = new Movie();
        movie2.setTitle("The Godfather II");
        movie2.setDescription("The early life and career of Vito Corleone in 1920s New York is portrayed while his son, Michael, expands and tightens his grip on his crime syndicate stretching from Lake Tahoe, Nevada to pre-revolution 1958 Cuba.");
        movie2.setPoster("http://ia.media-imdb.com/images/M/MV5BMjAxMTc5MTI3N15BMl5BanBnXkFtZTgwMTg0NTU0NzE@._V1_CR0,60,640,360_AL_UX477_CR0,0,477,268_AL_.jpg");

        Movie movie3 = new Movie();
        movie3.setTitle("The Dark Knight");
        movie3.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, the caped crusader must come to terms with one of the greatest psychological tests of his ability to fight injustice.");
        movie3.setPoster("http://ia.media-imdb.com/images/M/MV5BMjIxNDQyMzY1N15BMl5BanBnXkFtZTgwNDU5NTU0NzE@._V1_CR0,60,640,360_AL_UX477_CR0,0,477,268_AL_.jpg");

        Movie movie4 = new Movie();
        movie4.setTitle("12 Angry Men");
        movie4.setDescription("A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.");
        movie4.setPoster("http://ia.media-imdb.com/images/M/MV5BMTg3Mzg4NjE0M15BMl5BanBnXkFtZTcwNzkwODEzOA@@._V1_CR0,25,266,150_AL_UX477_CR0,0,477,268_AL_.jpg");

        Movie movie5 = new Movie();
        movie5.setTitle("Schindler's List");
        movie5.setDescription("In German-occupied Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazi Germans.");
        movie5.setPoster("http://ia.media-imdb.com/images/M/MV5BMTYzODcxNjkzMF5BMl5BanBnXkFtZTcwMjMxNTc2MQ@@._V1_CR0,30,250,141_AL_UX477_CR0,0,477,268_AL_.jpg");

        mMovies.add(movie);
        mMovies.add(movie1);
        mMovies.add(movie2);
        mMovies.add(movie3);
        mMovies.add(movie4);
        mMovies.add(movie5);

        return mMovies;
    }

    public static List<Book> loadBooks() {
        List<Book> mBooks = new ArrayList<>();

        Book book = new Book();
        book.setPoster("http://t1.gstatic.com/images?q=tbn:ANd9GcRBUelX9qRwyztKaeDcKNsCXtWjepsX35b_ufoBgfESxAZ71TLi");
        book.setTitle("American Gods");
        book.setAuthor("Neil Gaiman");
        book.setDescription("Locked behind bars for three years, Shadow did his time, quietly waiting for the magic day when he could return to Eagle Point, Indiana. A man no longer scared of what tomorrow might bring, all he wanted was to be with Laura, the wife he deeply loved, and start a new life.");

        Book book1 = new Book();
        book1.setPoster("http://t0.gstatic.com/images?q=tbn:ANd9GcSkSyi-AKY4GpMNnQZY5kU4avh26XcyakvZIoxrZzI9k2IynKBL");
        book1.setTitle("The Fault In Our Stars");
        book1.setAuthor("John Green");
        book1.setDescription("Despite the tumor-shrinking medical miracle that has bought her a few years, Hazel has never been anything but terminal, her final chapter inscribed upon diagnosis. But when a gorgeous plot twist named Augustus Waters suddenly appears at Cancer Kid Support Group, Hazel's story is about to be completely rewritten.");

        Book book2 = new Book();
        book2.setPoster("http://t2.gstatic.com/images?q=tbn:ANd9GcQJhGT7o4hghm3HbOhUGoKmFGwS96wXQseI9EcQPUc03ZbH6Qju");
        book2.setTitle("Shantaram");
        book2.setAuthor("Gregory David Roberts");
        book2.setDescription("It took me a long time and most of the world to learn what I know about love and fate and the choices we make, but the heart of it came to me in an instant, while I was chained to a wall and being tortured.\n\nSo begins this epic, mesmerizing first novel set in the underworld of contemporary Bombay. Shantaram is narrated by Lin, an escaped convict with a false passport who flees maximum security prison in Australia for the teeming streets of a city where he can disappear.");

        Book book3 = new Book();
        book3.setPoster("http://t3.gstatic.com/images?q=tbn:ANd9GcTNZqA6r9dd4kiUrigFmOraXCD2z-pFvdyzRoR1xJ-Djh4lX8BZ");
        book3.setTitle("Treasure Island");
        book3.setAuthor("Robert Louis Stevenson");
        book3.setDescription("The most popular pirate story ever written in English, featuring one of literature’s most beloved “bad guys,” Treasure Island has been happily devoured by several generations of boys—and girls—and grownups. Its unforgettable characters include: young Jim Hawkins, who finds himself owner of a map to Treasure Island, where the fabled pirate booty is buried; honest Captain Smollett, heroic Dr. Livesey, and the good-hearted but obtuse Squire Trelawney, who help Jim on his quest for the treasure; the frightening Blind Pew, double-dealing Israel Hands, and seemingly mad Ben Gunn, buccaneers of varying shades of menace; and, of course, garrulous, affable, ambiguous Long John Silver, who is one moment a friendly, laughing, one-legged sea-cook . . .and the next a dangerous pirate leader!");

        mBooks.add(book);
        mBooks.add(book1);
        mBooks.add(book2);
        mBooks.add(book3);

        return mBooks;
    }

    public static List<Book> loadExtraBooks() {
        Book book = new Book();
        book.setTitle("The Foundation");
        book.setPoster("https://images.gr-assets.com/books/1417900846l/29579.jpg");
        book.setAuthor("Isaac Asimov");
        book.setDescription("For twelve thousand years the Galactic Empire has ruled supreme. Now it is dying. But only Hari Seldon, creator of the revolutionary science of psychohistory, can see into the future -- to a dark age of ignorance, barbarism, and warfare that will last thirty thousand years. To preserve knowledge and save mankind, Seldon gathers the best minds in the Empire -- both scientists and scholars -- and brings them to a bleak planet at the edge of the Galaxy to serve as a beacon of hope for a future generations. He calls his sanctuary the Foundation.");

        Book book1 = new Book();
        book1.setTitle("Midnight's Children");
        book1.setAuthor("Salman Rushdie");
        book1.setPoster("https://images.gr-assets.com/books/1371063511l/14836.jpg");
        book1.setDescription("Born at the stroke of midnight, at the precise moment of India's independence, Saleem Sinai is destined from birth to be special. For he is one of 1,001 children born in the midnight hour, children who all have special gifts, children with whom Saleem is telepathically linked.");

        Book book2 = new Book();
        book2.setTitle("War and Peace");
        book2.setAuthor("Leo Tolstoy");
        book2.setPoster("https://images.gr-assets.com/books/1413215930l/656.jpg");
        book2.setDescription("Tolstoy's epic masterpiece intertwines the lives of private and public individuals during the time of the Napoleonic wars and the French invasion of Russia. The fortunes of the Rostovs and the Bolkonskys, of Pierre, Natasha, and Andrei, are intimately connected with the national history that is played out in parallel with their lives. Balls and soirees alternate with councils of war and the machinations of statesmen and generals, scenes of violent battles with everyday human passions in a work whose extraordinary imaginative power has never been surpassed. ");

        List<Book> extraBooks = new ArrayList<>();
        extraBooks.add(book);
        extraBooks.add(book1);
        extraBooks.add(book2);

        return extraBooks;
    }

    public static List<Movie> loadExtraMovies() {
        Movie movie = new Movie();
        movie.setTitle("Pulp Fiction");
        movie.setPoster("https://images-na.ssl-images-amazon.com/images/M/MV5BMjI5MzgxMTQ4M15BMl5BanBnXkFtZTgwNjczMTk0NzE@._V1_UX477_CR0,0,477,268_AL_.jpg");
        movie.setDescription("The lives of two mob hit men, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.");

        Movie movie1 = new Movie();
        movie1.setTitle("Fight Club");
        movie1.setPoster("https://images-na.ssl-images-amazon.com/images/M/MV5BMjEwNjY2NTc4MF5BMl5BanBnXkFtZTgwMTk2MTQ0NzE@._V1_CR0,60,640,360_AL_UX477_CR0,0,477,268_AL_.jpg");
        movie1.setDescription("An insomniac office worker, looking for a way to change his life, crosses paths with a devil-may-care soap maker, forming an underground fight club that evolves into something much, much more.");

        Movie movie2 = new Movie();
        movie2.setTitle("Forrest Gump");
        movie2.setPoster("https://images-na.ssl-images-amazon.com/images/M/MV5BMTU5MjI1MjUyOV5BMl5BanBnXkFtZTgwNzc1NTU0NzE@._V1_CR0,60,640,360_AL_UX477_CR0,0,477,268_AL_.jpg");
        movie2.setDescription("Forrest Gump, while not intelligent, has accidentally been present at many historic moments, but his true love, Jenny Curran, eludes him.");

        List<Movie> extraMovies = new ArrayList<>();
        extraMovies.add(movie);
        extraMovies.add(movie1);
        extraMovies.add(movie2);

        return extraMovies;
    }

}
