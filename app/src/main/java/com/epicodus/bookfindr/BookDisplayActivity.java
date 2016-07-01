package com.epicodus.bookfindr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BookDisplayActivity extends AppCompatActivity {
    private TextView mGenreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_display);
        mGenreInfo = (TextView) findViewById(R.id.genreInfo);
        Intent intent = getIntent();
        String genre = intent.getStringExtra("genre");
        mGenreInfo.setText("You selected " + genre + " as your genre.");
    }
}
