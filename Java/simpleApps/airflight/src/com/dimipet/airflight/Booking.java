package com.dimipet.airflight;

public class Booking {

	private String id;
	private Customer customer;
	private Flight flight;

	public Booking(String id, Customer customer, Flight flight) {
		super();
		this.id = id;
		this.customer = customer;
		this.flight = flight;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", customer=" + customer.toString() + ", flight=" + flight.toString() + "]";
	}

}
