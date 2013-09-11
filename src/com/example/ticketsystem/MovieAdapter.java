package com.example.ticketsystem;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MovieAdapter extends ArrayAdapter<Movie> {
	private Context context;
	private int layout_id;
	private List<Movie> ourMovies;

	public MovieAdapter(Context context, int textViewResourceId,
			List<Movie> objects) {
		super(context, textViewResourceId, objects);
		this.context = context;
		ourMovies = objects;
		layout_id = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater infl = ((Activity) context).getLayoutInflater();
		View movieRow = infl.inflate(layout_id, parent, false);
		TextView twTitlw = (TextView) movieRow
				.findViewById(R.id.list_view_movie_title);
		twTitlw.setText(ourMovies.get(position).getTitle());

		TextView twTickes = (TextView) movieRow
				.findViewById(R.id.list_view_movie_tickets_count);
		String t = String.valueOf(ourMovies.get(position).getTickets().size());
		twTickes.setText(t);
		return movieRow;
	}

}
