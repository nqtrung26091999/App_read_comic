package com.example.readcomic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ChapterActivity extends AppCompatActivity {
    public static final String TAG = "Test";
    private ListView lvChapter;
    private ArrayList<ChapterCls> chapterClsArrayList;
    private ChapterAdapter chapterAdapter;
    private Disposable mDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        lvChapter = findViewById(R.id.lvChapter);
        chapterClsArrayList = new ArrayList<>();
        getAllChapter();

    }

    private void getAllChapter() {
        APIServices.API_SERVICES.GET_ALL_CHAPTER()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<ChapterCls>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(@NonNull ArrayList<ChapterCls> chapterCls) {
                        chapterClsArrayList = chapterCls;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Toast.makeText(ChapterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                            chapterAdapter = new ChapterAdapter(ChapterActivity.this, R.layout.chapter_row, chapterClsArrayList);
                            lvChapter.setAdapter(chapterAdapter);
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }
}