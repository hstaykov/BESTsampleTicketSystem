package com.example.ticketsystem;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	
	@Override
	protected void onResume() {
		super.onResume();
		view.setAdapter(new MovieAdapter(this, R.layout.list_view_movies_layout, movies));
	}

	ListView view ;
	public static ArrayList<Movie> movies;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_linear);
		movies = createMovieList();	
		view = (ListView )findViewById(R.id.list_view_moives);
		movies.get(0).sellTicket(new Ticket());
		view.setAdapter(new MovieAdapter(this, R.layout.list_view_movies_layout, movies));
		view.setOnItemClickListener(new OnItemClickListener() {

			
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
					Toast.makeText(MainActivity.this, movies.get(arg2).getTitle(), Toast.LENGTH_LONG).show();
					Intent intent = new Intent(MainActivity.this, MovieActivity.class);
					intent.putExtra("MovieId", arg2);
					startActivity(intent);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private ArrayList<Movie> createMovieList(){
		ArrayList<Movie> ourMovies = new ArrayList<Movie>();
		ourMovies.add(new Movie("Batman", "Action", "http://www.imdb.com/title/tt0096895/"));
		ourMovies.add(new Movie("Superman", "Action", "http://www.imdb.com/title/tt0770828/"));
		ourMovies.add(new Movie("Iron Man 3", "Action", "http://www.imdb.com/title/tt1300854/"));
		ourMovies.add(new Movie("Aquaman", "Action", "http://www.imdb.com/title/tt0498318/"));		
		return ourMovies;
	}
	
	

}
