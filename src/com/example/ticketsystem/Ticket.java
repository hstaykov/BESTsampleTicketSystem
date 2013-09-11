package com.example.ticketsystem;


import java.util.Date;

public class Ticket {

	// Attributes
	private Movie movie;
	private double price;
	private Date date;
	private int seatNumber;

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	// Constructors
	public Ticket(Movie movie, double price, Date date, int seatNumber) {
		this.movie = movie;
		this.price = price;
		this.date = date;
		this.seatNumber = seatNumber;
	}

	public Ticket() {
	}

	// Methods
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Title: " + this.movie.getTitle() + "\n");
		sb.append("Price: " + this.price + "\n");
		sb.append("Date: " + this.date + "\n");
		sb.append("Seat: " + this.seatNumber + "\n");
		return sb.toString();
	}

}
