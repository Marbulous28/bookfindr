package com.epicodus.bookfindr;

/**
 * Created by Peter on 7/8/16.
 */
public class Book {
    private String mPublisher;
//    private String mAuthor;
//    private String mGenre;
//    private String mTitle;

    public Book(String publisher) {
        this.mPublisher = publisher;
//        this.mAuthor = author;
//        this.mGenre = genre;
//        this.mTitle = title;
    }

    public String getPublisher() {
        return mPublisher;
    }

//    public String getAuthor() {
//        return mAuthor;
//    }
//
//    public String getGenre() {
//        return mGenre;
//    }
//
//    public String getTitle() {
//        return mTitle;
//    }
}
