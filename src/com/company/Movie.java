package com.company;

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private final String _title;
    private int _priceCode;
    private Price _price;

    public Movie(String title, int priceCode){
        _title = title;
        setPriceCode(priceCode);
    };

    public int getPriceCode() {
        return _price.getPriceCode();
    };

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR -> _price = new RegularPrice();
            case NEW_RELEASE -> _price = new NewReleasePrice();
            case CHILDREN -> _price = new ChildrenPrice();
            default -> throw new IllegalArgumentException("Incorrect Price Code");
        }

    };

    public String getTitle() {
        return _title;
    };

    public double getCharge(int daysRented){
        return _price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }
}
