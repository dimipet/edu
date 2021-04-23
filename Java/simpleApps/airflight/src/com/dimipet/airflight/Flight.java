package com.dimipet.airflight;

import java.util.Date;
import java.util.Vector;

public class Flight {
	private String id;
    private String departuresFrom;
    private String arrivesTo;
    private Date departure;
    private Date arrival;
    
	public Flight(String id, String departuresFrom, String arrivesTo, Date departure, Date arrival) {
		super();
		this.id = id;
		this.departuresFrom = departuresFrom;
		this.arrivesTo = arrivesTo;
		this.departure = departure;
		this.arrival = arrival;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeparturesFrom() {
		return departuresFrom;
	}
	public void setDeparturesFrom(String departuresFrom) {
		this.departuresFrom = departuresFrom;
	}
	public String getArrivesTo() {
		return arrivesTo;
	}
	public void setArrivesTo(String arrivesTo) {
		this.arrivesTo = arrivesTo;
	}
	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Date departure) {
		this.departure = departure;
	}
	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", departuresFrom=" + departuresFrom + ", arrivesTo=" + arrivesTo + ", departure="
				+ departure + ", arrival=" + arrival + "]";
	}
    
}
