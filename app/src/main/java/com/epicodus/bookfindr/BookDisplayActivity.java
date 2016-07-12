package com.epicodus.bookfindr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.RunnableFuture;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class BookDisplayActivity extends AppCompatActivity {
    public static final String TAG = BookDisplayActivity.class.getSimpleName();

    @Bind(R.id.listView) ListView mListView;
    @Bind(R.id.genreInfo) TextView mGenreInfo;

    public ArrayList<Book> mBooks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_display);
        ButterKnife.bind(this);

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
            public void onResponse(Call call, Response response) {
                mBooks = bookService.processResults(response);

                BookDisplayActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] bookNames = new String[mBooks.size()];
                        for (int i=0; i < bookNames.length; i ++) {
                            bookNames[i] = mBooks.get(i).getPublisher();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(BookDisplayActivity.this,
                                android.R.layout.simple_list_item_1, bookNames);
                        mListView.setAdapter(adapter);

                        for (Book book : mBooks) {
                            Log.d(TAG, "Publisher: " + book.getPublisher());
                        }

                    }
                });
            }
        });
    }
}






