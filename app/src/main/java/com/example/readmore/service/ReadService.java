package com.example.readmore.service;
import android.util.Log;

import com.example.readmore.models.Books;
import com.example.readmore.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.arnaudguyon.xmltojsonlib.XmlToJson;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ReadService {
    private static final String TAG = ReadService.class.getSimpleName();

    public static void findTitle(String q, Callback callback) {
        String secret = "secret";
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.GOODREADS_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.GOODREADS_KEY_PARAMETER,Constants.GOODREADS_TOKEN);
        urlBuilder.addQueryParameter(Constants.GOODREADS_BOOKS_QUERY_PARAMETER, q);
        String url = urlBuilder.build().toString();
        Log.e(TAG, url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static ArrayList<Books> processResults(Response response) {
        ArrayList<Books> books = new ArrayList<>();
        try {
//
            String xmlData = response.body().string();
            XmlToJson xmlToJson = new XmlToJson.Builder(xmlData).build();
            JSONObject readJSON = xmlToJson.toJson();
            JSONArray businessesJSON = readJSON.getJSONArray("books");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return books;
    }
}

