package com.example.readcomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface APIServices {
    String url = "http://192.168.10.108:7900/";
    HttpLoggingInterceptor HTTP_LOGGING_INTERCEPTOR = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient.Builder BUILDER = new OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HTTP_LOGGING_INTERCEPTOR);

    APIServices API_SERVICES = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(BUILDER.build())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(APIServices.class);

    @GET("api/BOOK_CM_API")
    Observable<ArrayList<BookCls>> GET_ALL_BOOK();

    @GET("api/CHAPTER_CM_API")
    Observable<ArrayList<ChapterCls>> GET_ALL_CHAPTER();

    @GET("api/PAGE_CHAPTER_CM_API")
    Observable<ArrayList<PageCls>> GET_ALL_PAGES();
}

