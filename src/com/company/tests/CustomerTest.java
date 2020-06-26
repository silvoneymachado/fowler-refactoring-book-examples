package com.company.tests;

import com.company.Customer;
import com.company.Movie;
import com.company.Rental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    private Movie _movie;
    private Movie _movie2;
    private Rental _rental;
    private Rental _rental2;
    private Customer _customer;

    @BeforeEach
    void setUp() {
        _movie = new Movie("Titanic", 1);
        _movie2 = new Movie("Godzilla", 0);
        _rental = new Rental(_movie, 2);
        _rental2 = new Rental(_movie2, 2);
        _customer = new Customer("Foo");
    }

    @Test
    public void mustGetStatementForOneMovieWithPriceCode1(){
        int _frequentRenterPoints = 2;
        double _movieCharge = 6.0;
        _customer.addRental(_rental);

        String ref = String.format("Rental Record for %s\n", _customer.getName())
                + String.format("\t %s %s \n", _movie.getTitle(), String.valueOf(_movieCharge))
                + String.format("Amount owed is %s \n", String.valueOf(_movieCharge))
                + String.format("You earned %s  frequent renter points", String.valueOf(_frequentRenterPoints));
        String res = _customer.statement();;

        assertEquals(ref, res);
    }

    @Test
    public void mustGetStatementForOneMovieWithPriceCode0AndDaysRentedMoreThan2(){
        int _frequentRenterPoints = 2;
        double _movieCharge = 9.0;
        _rental = new Rental(_movie, 3);
        _customer.addRental(_rental);

        String ref = String.format("Rental Record for %s\n", _customer.getName())
                + String.format("\t %s %s \n", _movie.getTitle(), String.valueOf(_movieCharge))
                + String.format("Amount owed is %s \n", String.valueOf(_movieCharge))
                + String.format("You earned %s  frequent renter points", String.valueOf(_frequentRenterPoints));
        String res = _customer.statement();;

        assertEquals(ref, res);
    }

    @Test
    public void mustGetStatementForOneMovieWithPriceCode2(){
        int _frequentRenterPoints = 1;
        double _movieCharge = 1.5;
        _movie.setPriceCode(2);
        _customer.addRental(_rental);

        String ref = String.format("Rental Record for %s\n", _customer.getName())
                + String.format("\t %s %s \n", _movie.getTitle(), String.valueOf(_movieCharge))
                + String.format("Amount owed is %s \n", String.valueOf(_movieCharge))
                + String.format("You earned %s  frequent renter points", String.valueOf(_frequentRenterPoints));
        String res = _customer.statement();;

        assertEquals(ref, res);
    }

    @Test
    public void mustGetStatementForOneMovieWithPriceCode2AndDaysRentedMoreThan3(){
        int _frequentRenterPoints = 1;
        double _movieCharge = 3.0;
        _movie.setPriceCode(2);
        _rental = new Rental(_movie, 4);
        _customer.addRental(_rental);

        String ref = String.format("Rental Record for %s\n", _customer.getName())
                + String.format("\t %s %s \n", _movie.getTitle(), String.valueOf(_movieCharge))
                + String.format("Amount owed is %s \n", String.valueOf(_movieCharge))
                + String.format("You earned %s  frequent renter points", String.valueOf(_frequentRenterPoints));
        String res = _customer.statement();;

        assertEquals(ref, res);
    }

    @Test
    public void mustGetStatementForTwoMovies(){
        int _frequentRenterPoints = 3;
        double _movie1Charge = 6.0;
        double _movie2Charge = 2.0;
        _customer.addRental(_rental);
        _customer.addRental(_rental2);

        String ref = String.format("Rental Record for %s\n", _customer.getName())
                + String.format("\t %s %s \n", _movie.getTitle(), String.valueOf(_movie1Charge))
                + String.format("\t %s %s \n", _movie2.getTitle(), String.valueOf(_movie2Charge))
                + String.format("Amount owed is %s \n", String.valueOf(_movie1Charge + _movie2Charge))
                + String.format("You earned %s  frequent renter points", String.valueOf(_frequentRenterPoints));
        String res = _customer.statement();

        assertEquals(ref, res);
    }

    @Test
    public void mustGetHtmlStatementForOneMovieWithPriceCode1(){
        int _frequentRenterPoints = 2;
        double _movieCharge = 6.0;
        _customer.addRental(_rental);

        String ref = "<h1>Rentals for <em>"
                + _customer.getName()
                + "</em></h1><p>\n"
                + _movie.getTitle()
                + ": "
                + String.valueOf(_rental.getCharge())
                + "<br/>\n"
                + "<p>You owe <em>"
                + String.valueOf(_movieCharge)
                + "</em></p>\n"
                + "On this rental you earned <em>"
                + String.valueOf(_frequentRenterPoints)
                + "</em> frequent renter points </p>";

        String res = _customer.htmlStatement();;

        assertEquals(ref, res);
    }

    @Test
    public void mustGetTotalChargeWithTwoMoviesPriceCode1AndPriceCode0(){
        double _totalCharge = 8.0;
        _customer.addRental(_rental);
        _customer.addRental(_rental2);

        double res = _customer.getTotalCharge();

        assertEquals(_totalCharge, res);
    }

    @Test
    public void mustGetTotalFrequentRenterPointsWithTwoMoviesPriceCode1AndPriceCode0(){
        int _frequentRenterPoints = 3;
        _customer.addRental(_rental);
        _customer.addRental(_rental2);

        double res = _customer.getTotalFrequentRenterPoints();

        assertEquals(_frequentRenterPoints, res);
    }

}