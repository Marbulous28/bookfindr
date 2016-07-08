package com.epicodus.bookfindr;


import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Peter on 7/8/16.
 */
public class BookService {

    public static void findBooks(String subject, String keyword, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        String url = Constants.GOOGLE_BASE_URL + keyword + "+inauthor:" + subject +"&key=" + Constants.GOOGLE_BOOKS_KEY;

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }

}
