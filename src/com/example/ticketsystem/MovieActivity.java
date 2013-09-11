package com.example.ticketsystem;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MovieActivity extends Activity implements OnClickListener{
	TextView title;
	TextView tickets;
	Button btnGoImdb;
	Button btnOrderTicket;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.movie_laytout_linear);
		title = (TextView)findViewById(R.id.movie_title);
		tickets = (TextView)findViewById(R.id.tickets_number);
		btnGoImdb = (Button)findViewById(R.id.btn_go_to_imdb);
		btnOrderTicket = (Button)findViewById(R.id.btn_orderTicket);
		
		btnGoImdb.setOnClickListener(this);
		btnOrderTicket.setOnClickListener(this);
		// Intent browserIntent = new Intent(Intent.ACTION_VIEW,
		// Uri.parse((String) savedInstanceState.get("Movie")));
		// startActivity(browserIntent);
	}

	@Override
	protected void onResume() {
		super.onResume();
		int movieId = getIntent().getIntExtra("MovieId", 0);
		title.setText(MainActivity.movies.get(movieId).getTitle());
		tickets.setText("Sold tickets: " + MainActivity.movies.get(movieId).getTickets().size());
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int movieId = getIntent().getIntExtra("MovieId", 0);
		if(v.getId() == btnGoImdb.getId()){
				Log.d("TICKET", "We are trying to reach the browser...");
			 Intent browserIntent = new Intent(Intent.ACTION_VIEW,
			 Uri.parse((String)MainActivity.movies.get(movieId).getImdbUrl()));
			 startActivity(browserIntent);
		}
		else if (v.getId() == btnOrderTicket.getId()){
			MainActivity.movies.get(movieId).sellTicket(new Ticket());
			tickets.setText("Sold tickets: " + MainActivity.movies.get(movieId).getTickets().size());
		}
	}

}
