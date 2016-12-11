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
    }

}
