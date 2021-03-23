package com.example.rohanjuneja_assignment2;


public class Listings {
    //Variables for image, address and prices
    private  int image;
    private String address;
    private  String price;

    //Constructor
    public Listings(int image, String address, String price) {
        this.image = image;
        this.address = address;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {

        this.image = image;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getPrice() {

        return price;
    }

    public void setPrice(String price) {

        this.price = price;
    }


}
