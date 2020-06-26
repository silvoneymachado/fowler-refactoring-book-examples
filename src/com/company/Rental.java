package com.company;

public class Rental {
    final Movie _movie;
    private final int _daysRented;

    public Rental(Movie movie, int daysRented){
        _movie = movie;
        _daysRented = daysRented;
    };

    public int getDaysRented() {
        return _daysRented;
    };

    public Movie getMovie() {
        return _movie;
    };

    public double getCharge(){
        return _movie.getCharge(_daysRented);
    }

    public int getFrequentRenterPoints() {
        return _movie.getFrequentRenterPoints(_daysRented);
    }
}
