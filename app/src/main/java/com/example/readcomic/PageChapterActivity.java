package com.example.readcomic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PageChapterActivity extends AppCompatActivity {
    private ListView lvPage;
    private ArrayList<PageCls> pageClsArrayList;
    private PageAdapter pageAdapter;
    private Disposable mDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_chapter);
        lvPage = findViewById(R.id.lvPage);
        pageClsArrayList = new ArrayList<>();
        geAllPages();
    }

    private void geAllPages() {
        APIServices.API_SERVICES.GET_ALL_PAGES()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<PageCls>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(@NonNull ArrayList<PageCls> pageCls) {
                        pageClsArrayList = pageCls;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Toast.makeText(PageChapterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        pageAdapter = new PageAdapter(PageChapterActivity.this, R.layout.page_row, pageClsArrayList);
                        lvPage.setAdapter(pageAdapter);
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