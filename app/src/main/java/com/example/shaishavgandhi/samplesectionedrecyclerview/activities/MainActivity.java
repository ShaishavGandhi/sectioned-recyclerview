package com.example.shaishavgandhi.samplesectionedrecyclerview.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.shaishavgandhi.samplesectionedrecyclerview.adapters.Adapter;
import com.example.shaishavgandhi.samplesectionedrecyclerview.R;
import com.example.shaishavgandhi.samplesectionedrecyclerview.data.DataLoader;
import com.example.shaishavgandhi.samplesectionedrecyclerview.data.models.Book;
import com.example.shaishavgandhi.samplesectionedrecyclerview.data.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Movie> mMovies;
    List<Book> mBooks;

    List<Movie> extraMovies;
    List<Book> extraBooks;

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mMovies = new ArrayList<>();
        mBooks = new ArrayList<>();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

        populateData();
        populateExtraData();

        adapter = new Adapter(this, mMovies, mBooks);
        mRecyclerView.setAdapter(adapter);
    }

    private void populateExtraData() {
        extraMovies = DataLoader.loadExtraMovies();
        extraBooks = DataLoader.loadExtraBooks();
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
        if (id == R.id.action_add_book_at_start) {
            addBook(0);
            return true;
        }

        if (id == R.id.action_add_book_at_end) {
            addBook();
            return true;
        }

        if (id == R.id.action_add_movie_at_start) {
            addMovie(0);
            return true;
        }

        if (id == R.id.action_add_movie_at_end) {
            addMovie();
            return true;
        }

        if (id == R.id.action_remove_movie_at_start) {
            removeMovie(0);
        }

        if (id == R.id.action_remove_movie_at_end) {
            removeMovie();
        }

        if (id == R.id.action_remove_book_at_start) {
            removeBook(0);
        }

        if (id == R.id.action_remove_book_at_end) {
            removeBook();
        }

        return super.onOptionsItemSelected(item);
    }

    private void addBook(int position) {
        if (extraBooks.size() > 0) {
            adapter.addBook(extraBooks.get(0), position);
            extraBooks.remove(0);
        } else {
            Toast.makeText(getApplicationContext(), "No more movies left", Toast.LENGTH_SHORT).show();
        }
    }

    private void addBook() {
        if (extraBooks.size() > 0) {
            adapter.addBook(extraBooks.get(0));
            extraBooks.remove(0);
        } else {
            Toast.makeText(getApplicationContext(), "No more movies left", Toast.LENGTH_SHORT).show();
        }
    }

    private void addMovie(int position) {
        if (extraMovies.size() > 0) {
            adapter.addMovie(extraMovies.get(0), position);
            extraMovies.remove(0);
        } else {
            Toast.makeText(getApplicationContext(), "No more movies left", Toast.LENGTH_SHORT).show();
        }
    }

    private void addMovie() {
        if (extraMovies.size() > 0) {
            adapter.addMovie(extraMovies.get(0));
            extraMovies.remove(0);
        } else {
            Toast.makeText(getApplicationContext(), "No more movies left", Toast.LENGTH_SHORT).show();
        }
    }

    private void removeMovie() {
        adapter.removeMovie();
    }

    private void removeMovie(int position) {
        adapter.removeMovie(position);
    }

    private void removeBook() {
        adapter.removeBook();
    }

    private void removeBook(int position) {
        adapter.removeBook(position);
    }

    private void populateData() {
        mMovies = DataLoader.loadMovies();
        mBooks = DataLoader.loadBooks();
    }

}
