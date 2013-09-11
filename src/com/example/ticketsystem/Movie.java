package com.example.ticketsystem;


import java.util.ArrayList;

public class Movie {
	private String title;
	private String genre;
	private String imdbUrl;
	private ArrayList<Ticket> tickets;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getImdbUrl() {
		return imdbUrl;
	}

	public void setImdbUrl(String imdbUrl) {
		this.imdbUrl = imdbUrl;
	}

	public Movie(String title, String genre, String imdbUrl) {
		super();
		this.title = title;
		this.genre = genre;
		this.imdbUrl = imdbUrl;
		this.tickets = new ArrayList<Ticket>();
	}
	
	//Methods
	public int sellTicket(Ticket ticket){
		this.tickets.add(ticket);
		return this.tickets.size();
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Ticket t : this.tickets) {
			sb.append("Seat: " + t.getSeatNumber() + " Price: " + t.getPrice());
			
		}
		return sb.toString();
	}

	
}