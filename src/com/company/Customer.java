package com.company;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private final String _name;
    private final Vector<Rental> _rentals = new Vector<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental rental) {
        _rentals.addElement(rental);
    }

    public String getName() {
        return _name;
    }

    public double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = _rentals.elements();

        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each._movie.getCharge(each.getDaysRented());
        }

        return result;
    }

    public int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentals = _rentals.elements();

        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }

        return result;
    }

    public String statement() {
        Enumeration<Rental> rentals = _rentals.elements();
        StringBuilder result = new StringBuilder(String.format("Rental Record for %s\n", getName()));
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            // show figures for this rental
            result.append(String.format("\t %s %s \n", each.getMovie().getTitle(), each._movie.getCharge(each.getDaysRented())));
        }
        // add footer lines
        result.append(String.format("Amount owed is %s \n", getTotalCharge()));
        result.append(String.format("You earned %s  frequent renter points", getTotalFrequentRenterPoints()));

        return result.toString();
    }

    public String htmlStatement(){
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "<h1>Rentals for <em>"
                + getName()
                + "</em></h1><p>\n";
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            // show figures for this rental
            result += each.getMovie().getTitle()
                + ": "
                + String.valueOf(each._movie.getCharge(each.getDaysRented()))
                + "<br/>\n";
        }
        // add footer lines
        result += "<p>You owe <em>"
                + String.valueOf(getTotalCharge())
                + "</em></p>\n";
        result += "On this rental you earned <em>"
                + String.valueOf(getTotalFrequentRenterPoints())
                + "</em> frequent renter points </p>";
        return result;
    }
}
