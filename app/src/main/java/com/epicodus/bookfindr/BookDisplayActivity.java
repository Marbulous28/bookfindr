package com.epicodus.bookfindr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class BookDisplayActivity extends AppCompatActivity {
    private String[] books = new String[] {"The Fellowship of the Ring", "The Two Towers", "The Return of the King",
    "The Hobbit", "The Name of the Wind", "The Wise Man's Fear", "The Doors of Stone"};
    private ListView mListView;
    private TextView mGenreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_display);

        mListView = (ListView) findViewById(R.id.listView);
        mGenreInfo = (TextView) findViewById(R.id.genreInfo);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, books);
        mListView.setAdapter(adapter);

        Intent intent = getIntent();
        String genre = intent.getStringExtra("genre");
        mGenreInfo.setText("You selected " + genre + " as your genre.");
    }
}
