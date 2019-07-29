package com.example.readmore;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ReadService {
    public static void findTitle(String title, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.GOODREADS_BASE_URL ).newBuilder();
        urlBuilder.addQueryParameter(Constants.GOODREADS_Books_QUERY_PARAMETER, title);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", Constants.GOODREADS_TOKEN)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}