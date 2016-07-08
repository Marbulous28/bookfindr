package com.epicodus.bookfindr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class BookDisplayActivity extends AppCompatActivity {
    public static final String TAG = BookDisplayActivity.class.getSimpleName();

    private String[] books = new String[] {"The Fellowship of the Ring", "The Two Towers", "The Return of the King",
    "The Hobbit", "The Name of the Wind", "The Wise Man's Fear", "The Doors of Stone"};
    @Bind(R.id.listView) ListView mListView;
    @Bind(R.id.genreInfo) TextView mGenreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_display);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, books);
        mListView.setAdapter(adapter);

        Intent intent = getIntent();
        String subject = intent.getStringExtra("subject");
        String keyword = intent.getStringExtra("keyword");
        mGenreInfo.setText("You selected " + subject + " as your genre.");

        getBooks(keyword, subject);
    }

    private void getBooks(String keyword, String subject) {
       final BookService bookService = new BookService();
        bookService.findBooks(keyword, subject, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}






