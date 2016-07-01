package com.epicodus.bookfindr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button mFindBooksButton;
    private EditText mGenreInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGenreInput = (EditText) findViewById(R.id.genreInput);
        mFindBooksButton = (Button) findViewById(R.id.findBooksButton);
        mFindBooksButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String genre = mGenreInput.getText().toString();
                Intent intent = new Intent(MainActivity.this, BookDisplayActivity.class);
                intent.putExtra("genre", genre);
                startActivity(intent);
            }
        });
    }
}
