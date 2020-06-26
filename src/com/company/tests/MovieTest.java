package com.company.tests;

import com.company.Customer;
import com.company.Movie;
import com.company.Rental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {
    private Movie _movie;
    private Rental _rental;
    private Customer _customer;

    @BeforeEach
    void setUp() {
        _movie = new Movie("Titanic", 1);
        _rental = new Rental(_movie, 2);
        _customer = new Customer("Foo");
    }

    @Test
    public void mustGetChargeWithPriceCode0(){
        double _thisAmount = 2.0;
        _movie.setPriceCode(0);
        _customer.addRental(_rental);
        double res = _movie.getCharge(_rental.getDaysRented());

        assertEquals(_thisAmount, res);
    }

    @Test
    public void mustGetChargeWithPriceCode0AndDaysRentedMoreThan2(){
        double _thisAmount = 3.5;
        _movie.setPriceCode(0);
        _rental = new Rental(_movie, 3);
        _customer.addRental(_rental);
        double res = _movie.getCharge(_rental.getDaysRented());

        assertEquals(_thisAmount, res);
    }

    @Test
    public void mustGetChargeWithPriceCode1(){
        double _thisAmount = 2.0;
        _movie.setPriceCode(0);
        _customer.addRental(_rental);
        double res = _movie.getCharge(_rental.getDaysRented());

        assertEquals(_thisAmount, res);
    }

    @Test
    public void mustGetChargeWithPriceCode2(){
        double _thisAmount = 2.0;
        _movie.setPriceCode(0);
        _customer.addRental(_rental);
        double res = _movie.getCharge(_rental.getDaysRented());

        assertEquals(_thisAmount, res);
    }

    @Test
    public void mustGetChargeWithPriceCode2AndDaysRentedMoreThan3(){
        double _thisAmount = 5.0;
        _movie.setPriceCode(0);
        _rental = new Rental(_movie, 4);
        _customer.addRental(_rental);
        double res = _movie.getCharge(_rental.getDaysRented());

        assertEquals(_thisAmount, res);
    }

    @Test
    public void mustGetFrequentRentalPoints(){
        int _frequentRenterPoints = 1;
        _movie.setPriceCode(2);
        _customer.addRental(_rental);
        double res = _movie.getFrequentRenterPoints(_rental.getDaysRented());

        assertEquals(_frequentRenterPoints, res);
    }
}