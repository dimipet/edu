package com.dimipet.airflight;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * simple app that models a dead simple airline office
 * 
 * use jdk6
 */

public class App {
	
    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] args) {
        Vector<Customer> customers = new Vector<Customer>();
        customers.add(new Customer("cp-4450", "James Gosling"));
        customers.add(new Customer("cp-4451", "Patrick Naughton"));
        customers.add(new Customer("cp-4452", "Mike Sheridan"));
        
        Vector<Flight> flights = new Vector<Flight>();
        // SKG to ATH
        flights.add(new Flight("", "SKG", "ATH", parseDate("2008-01-01 00:00:01"), parseDate("2008-01-01 01:13:44")));
        flights.add(new Flight("", "SKG", "ATH", parseDate("2008-01-01 08:00:01"), parseDate("2008-01-01 09:13:44")));
        flights.add(new Flight("", "SKG", "ATH", parseDate("2008-01-01 16:00:01"), parseDate("2008-01-01 17:13:44")));
        flights.add(new Flight("", "SKG", "ATH", parseDate("2008-01-01 22:00:01"), parseDate("2008-01-01 23:13:44")));
        flights.add(new Flight("", "SKG", "ATH", parseDate("2008-01-02 00:00:01"), parseDate("2008-01-02 01:13:44")));
        flights.add(new Flight("", "SKG", "ATH", parseDate("2008-01-02 08:00:01"), parseDate("2008-01-02 09:13:44")));
        flights.add(new Flight("", "SKG", "ATH", parseDate("2008-01-02 16:00:01"), parseDate("2008-01-02 17:13:44")));
        flights.add(new Flight("", "SKG", "ATH", parseDate("2008-01-02 22:00:01"), parseDate("2008-01-02 23:13:44")));
        flights.add(new Flight("", "SKG", "ATH", parseDate("2008-01-03 00:00:01"), parseDate("2008-01-03 01:13:44")));
        flights.add(new Flight("", "SKG", "ATH", parseDate("2008-01-03 08:00:01"), parseDate("2008-01-03 09:13:44")));
        flights.add(new Flight("", "SKG", "ATH", parseDate("2008-01-03 16:00:01"), parseDate("2008-01-03 17:13:44")));
        flights.add(new Flight("", "SKG", "ATH", parseDate("2008-01-03 22:00:01"), parseDate("2008-01-03 23:13:44")));
        // ATH to SKG
        flights.add(new Flight("", "ATH", "SKG", parseDate("2008-01-01 02:00:01"), parseDate("2008-01-01 03:13:44")));
        flights.add(new Flight("", "ATH", "SKG", parseDate("2008-01-01 10:00:01"), parseDate("2008-01-01 11:13:44")));
        flights.add(new Flight("", "ATH", "SKG", parseDate("2008-01-01 18:00:01"), parseDate("2008-01-01 19:13:44")));
        flights.add(new Flight("", "ATH", "SKG", parseDate("2008-01-01 23:50:01"), parseDate("2008-01-02 01:03:44")));
        flights.add(new Flight("", "ATH", "SKG", parseDate("2008-01-02 02:00:01"), parseDate("2008-01-02 03:13:44")));
        flights.add(new Flight("", "ATH", "SKG", parseDate("2008-01-02 10:00:01"), parseDate("2008-01-02 11:13:44")));
        flights.add(new Flight("", "ATH", "SKG", parseDate("2008-01-02 18:00:01"), parseDate("2008-01-02 19:13:44")));
        flights.add(new Flight("", "ATH", "SKG", parseDate("2008-01-02 23:50:01"), parseDate("2008-01-03 01:03:44")));
        flights.add(new Flight("", "ATH", "SKG", parseDate("2008-01-03 02:00:01"), parseDate("2008-01-03 03:13:44")));
        flights.add(new Flight("", "ATH", "SKG", parseDate("2008-01-03 10:00:01"), parseDate("2008-01-03 11:13:44")));
        flights.add(new Flight("", "ATH", "SKG", parseDate("2008-01-03 18:00:01"), parseDate("2008-01-03 19:13:44")));
        flights.add(new Flight("", "ATH", "SKG", parseDate("2008-01-03 23:50:01"), parseDate("2008-01-04 01:03:44")));
        // SKG to KAV
        flights.add(new Flight("", "SKG", "KAV", parseDate("2008-01-01 00:33:01"), parseDate("2008-01-01 01:09:44")));
        flights.add(new Flight("", "SKG", "KAV", parseDate("2008-01-01 16:33:01"), parseDate("2008-01-01 17:09:44")));
        flights.add(new Flight("", "SKG", "KAV", parseDate("2008-01-02 00:33:01"), parseDate("2008-01-02 01:09:44")));
        flights.add(new Flight("", "SKG", "KAV", parseDate("2008-01-02 16:33:01"), parseDate("2008-01-02 17:09:44")));
        flights.add(new Flight("", "SKG", "KAV", parseDate("2008-01-03 00:33:01"), parseDate("2008-01-03 01:09:44")));
        flights.add(new Flight("", "SKG", "KAV", parseDate("2008-01-03 16:33:01"), parseDate("2008-01-03 17:09:44")));
        // KAV to SKG
        flights.add(new Flight("", "KAV", "SKG", parseDate("2008-01-01 10:55:01"), parseDate("2008-01-01 11:09:44")));
        flights.add(new Flight("", "KAV", "SKG", parseDate("2008-01-01 23:55:01"), parseDate("2008-01-02 01:09:44")));
        flights.add(new Flight("", "KAV", "SKG", parseDate("2008-01-02 10:55:01"), parseDate("2008-01-02 11:09:44")));
        flights.add(new Flight("", "KAV", "SKG", parseDate("2008-01-02 23:55:01"), parseDate("2008-01-03 01:09:44")));
        flights.add(new Flight("", "KAV", "SKG", parseDate("2008-01-03 10:55:01"), parseDate("2008-01-03 11:09:44")));
        flights.add(new Flight("", "KAV", "SKG", parseDate("2008-01-03 23:55:01"), parseDate("2008-01-04 01:09:44")));
        // ATH to KAV
        flights.add(new Flight("", "ATH", "KAV", parseDate("2008-01-01 00:22:01"), parseDate("2008-01-01 01:41:44")));
        flights.add(new Flight("", "ATH", "KAV", parseDate("2008-01-02 00:22:01"), parseDate("2008-01-02 01:41:44")));
        flights.add(new Flight("", "ATH", "KAV", parseDate("2008-01-03 00:22:01"), parseDate("2008-01-03 01:41:44")));
        // KAV to ATH
        flights.add(new Flight("", "KAV", "SKG", parseDate("2008-01-01 16:55:01"), parseDate("2008-01-01 17:16:44")));
        flights.add(new Flight("", "KAV", "SKG", parseDate("2008-01-02 16:55:01"), parseDate("2008-01-02 17:16:44")));
        flights.add(new Flight("", "KAV", "SKG", parseDate("2008-01-03 16:55:01"), parseDate("2008-01-03 17:16:44")));
        
        // book tickets for customers
        Vector<Booking> bookings = new Vector<Booking>();
        bookings.add(new Booking("", customers.get(0), flights.get(0)));
        bookings.add(new Booking("", customers.get(1), flights.get(1)));
        bookings.add(new Booking("", customers.get(2), flights.get(6)));
        bookings.add(new Booking("", customers.get(0), flights.get(2)));
        bookings.add(new Booking("", customers.get(1), flights.get(3)));
        bookings.add(new Booking("", customers.get(2), flights.get(9)));
        bookings.add(new Booking("", customers.get(0), flights.get(4)));
        bookings.add(new Booking("", customers.get(1), flights.get(5)));
        bookings.add(new Booking("", customers.get(2), flights.get(8)));

        System.out.println("---------------------------------------------------");
        System.out.println("show all customers");
        for(Customer c : customers) {
        	System.out.println(c.toString());
        }
        
        System.out.println("---------------------------------------------------");
        System.out.println("show all available flights");
        for(Flight f : flights) {
        	System.out.println(f.toString());
        }
        
        System.out.println("---------------------------------------------------");
        System.out.println("show all bookings");
        for(Booking b : bookings) {
        	System.out.println(b.toString());
        }

        System.out.println("---------------------------------------------------");
		System.out.println("check if there exists specific flight that departures from SKG");
        String str1 = "SKG";
        for(Flight f : flights) {
        	if(f.getDeparturesFrom().equalsIgnoreCase(str1)) {
        		System.out.println(f.toString());
        	}
        }

        System.out.println("---------------------------------------------------");
		System.out.println("check if there exists specific flight that arrives to ATH");
        String str2 = "ATH";
        for(Flight f : flights) {
        	if(f.getArrivesTo().equalsIgnoreCase(str2)) {
        		System.out.println(f.toString());
        	}
        }
        
        System.out.println("---------------------------------------------------");
		System.out.println("check if there exists specific flight from SKG with specific departure date");
        Date d1 = parseDate("2008-01-01 00:33:01");
        for(Flight f : flights) {
        	if(f.getDeparturesFrom().equalsIgnoreCase(str1) &&
        			f.getDeparture().equals(d1)
        			) {
        		System.out.println(f.toString());
        	}
        }
        
        
        
	}

	
    public static Date parseDate(String dts) {
    	Date ret = null;
		try {
			ret = formatter.parse(dts);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ret;
    }

}
