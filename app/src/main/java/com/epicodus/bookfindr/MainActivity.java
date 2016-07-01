package com.epicodus.bookfindr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.findBooksButton) Button mFindBooksButton;
    @Bind(R.id.genreInput) EditText mGenreInput;
    @Bind(R.id.userBooksButton) Button mUserBooksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFindBooksButton.setOnClickListener(this);
        mUserBooksButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mFindBooksButton) {
            String genre = mGenreInput.getText().toString();
            Intent intent = new Intent(MainActivity.this, BookDisplayActivity.class);
            intent.putExtra("genre", genre);
            startActivity(intent);
        } else if (v == mUserBooksButton) {
            Intent intent = new Intent(MainActivity.this, UserBooksPageActivity.class);
            startActivity(intent);
        }

    }
}
