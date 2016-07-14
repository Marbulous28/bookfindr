package com.epicodus.bookfindr.models;

/**
 * Created by Peter on 7/8/16.
 */
public class Book {
    private String mTitle;
    private String mRating;


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
