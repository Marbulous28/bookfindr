package com.epicodus.bookfindr.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.bookfindr.R;
import com.epicodus.bookfindr.models.Book;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BookDetailFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.ratingTextView) TextView mRatingLabel;
    @Bind(R.id.bookTitleTextView) TextView mNameLabel;
    @Bind(R.id.websiteTextView) TextView mWebsiteLabel;

    private Book mBook;

    public static BookDetailFragment newInstance(Book book) {
        BookDetailFragment bookDetailFragment = new BookDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("book", Parcels.wrap(book));
        bookDetailFragment.setArguments(args);
        return bookDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBook = Parcels.unwrap(getArguments().getParcelable("book"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_detail, container, false);
        ButterKnife.bind(this, view);
        mWebsiteLabel.setOnClickListener(this);


        mNameLabel.setText(mBook.getTitle());
        mRatingLabel.setText(mBook.getRating());

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.amazon.com/"));
            startActivity(webIntent);
        }
    }
}
