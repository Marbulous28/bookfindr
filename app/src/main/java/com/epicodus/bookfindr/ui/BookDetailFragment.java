package com.epicodus.bookfindr.ui;


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

public class BookDetailFragment extends Fragment {
    @Bind(R.id.ratingTextView) TextView mRatingLabel;
    @Bind(R.id.bookTitleTextView) TextView mNameLabel;

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


        mNameLabel.setText(mBook.getTitle());
        mRatingLabel.setText(mBook.getRating());

        return view;
    }
}
