package com.company;

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private final String _title;
    private int _priceCode;

    public Movie(String title, int priceCode){
        _title = title;
        _priceCode = priceCode;
    };

    public int getPriceCode() {
        return _priceCode;
    };

    public void setPriceCode(int priceCode) {
        _priceCode = priceCode;
    };

    public String getTitle() {
        return _title;
    };

    public double getCharge(int daysRented){
        double result = 0;
        //determine amounts for aRental line
        switch (getPriceCode()) {
            case REGULAR -> {
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
            }
            case NEW_RELEASE -> result += daysRented * 3;
            case CHILDREN -> {
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
            }
        }

        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
            return 2;
        else
            return 1;
    }
}
