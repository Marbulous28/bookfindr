package com.epicodus.bookfindr.services;


import com.epicodus.bookfindr.Constants;
import com.epicodus.bookfindr.models.Book;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
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

        String url = Constants.GOOGLE_BASE_URL + keyword + "+subject:" + subject +"&key=" + Constants.GOOGLE_BOOKS_KEY;

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    public ArrayList<Book> processResults(Response response) {
        ArrayList<Book> books = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject googleJSON = new JSONObject(jsonData);
                JSONArray itemsJSON = googleJSON.getJSONArray("items");
                for (int i = 0; i < itemsJSON.length(); i++) {
                    JSONObject bookJSON = itemsJSON.getJSONObject(i);
                    JSONObject volumeInfo = bookJSON.getJSONObject("volumeInfo");
                    String title = volumeInfo.getString("title");
                    String rating = volumeInfo.getString("averageRating");



                    Book book = new Book(title, rating);
                    books.add(book);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return books;
    }

}
