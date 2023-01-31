package com.example.touristapp;

public class Place {
    String countryName;
    String capitalName;
    String placeName;
    Integer placeImage;
    Integer placePrice;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Integer getPlaceImage() {
        return placeImage;
    }

    public void setPlaceImage(Integer placeImage) {
        this.placeImage = placeImage;
    }

    public Integer getPlacePrice() {
        return placePrice;
    }

    public void setPlacePrice(Integer placePrice) {
        this.placePrice = placePrice;
    }

    public Place(String countryName, String capitalName, String placeName, Integer placeImage, Integer placePrice) {
        this.countryName = countryName;
        this.capitalName = capitalName;
        this.placeName = placeName;
        this.placeImage = placeImage;
        this.placePrice = placePrice;


    }
}
