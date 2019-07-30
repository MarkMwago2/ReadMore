package com.example.readmore;
import com.google.gson.Gson;

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
    public static void findTitle(String title, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.GOODREADS_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.GOODREADS_Books_QUERY_PARAMETER, title);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", Constants.GOODREADS_TOKEN)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static List<Books> processResults(Response response) {
        List<Books> books = new ArrayList<>();
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

