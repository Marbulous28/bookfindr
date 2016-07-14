package com.epicodus.bookfindr.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.bookfindr.R;
import com.epicodus.bookfindr.adapters.BookListAdapter;
import com.epicodus.bookfindr.models.Book;
import com.epicodus.bookfindr.services.BookService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class BookDisplayActivity extends AppCompatActivity {
    public static final String TAG = BookDisplayActivity.class.getSimpleName();

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private BookListAdapter mAdapter;

    public ArrayList<Book> mBooks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_display);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String subject = intent.getStringExtra("subject");
        String keyword = intent.getStringExtra("keyword");

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
                        mAdapter = new BookListAdapter(getApplicationContext(), mBooks);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(BookDisplayActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}






