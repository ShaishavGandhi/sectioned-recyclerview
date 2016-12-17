package com.example.shaishavgandhi.samplesectionedrecyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.shaishavgandhi.samplesectionedrecyclerview.models.Book;
import com.example.shaishavgandhi.samplesectionedrecyclerview.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Movie> mMovies;
    List<Book> mBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mMovies = new ArrayList<>();
        mBooks = new ArrayList<>();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

        populateData();

        Adapter adapter = new Adapter(this, mMovies, mBooks);
        mRecyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void populateData() {
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

    }

}
