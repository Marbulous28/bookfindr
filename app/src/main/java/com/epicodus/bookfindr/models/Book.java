package com.epicodus.bookfindr.models;


import org.parceler.Parcel;

@Parcel
public class Book {
    private String mTitle;
    private String mRating;

    public Book() {}


    public Book(String title, String rating) {
        this.mTitle = title;
        this.mRating = rating;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getRating() {
        return mRating;
    }
}
