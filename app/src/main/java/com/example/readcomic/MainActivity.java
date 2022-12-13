package com.example.readcomic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private ArrayList<BookCls> bookClsList;
    private ListView lvBook;
    private BookAdapter bookAdapter;
    private Disposable mDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        bookClsList = new ArrayList<>();
        Act();
    }

    private void Act() {
        getAllBook();
    }

    private void getAllBook() {
        APIServices.API_SERVICES.GET_ALL_BOOK()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<BookCls>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(@NonNull ArrayList<BookCls> bookCls) {
                        bookClsList = bookCls;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        bookAdapter = new BookAdapter(MainActivity.this, R.layout.book_row, bookClsList);
                        lvBook.setAdapter(bookAdapter);
                    }
                });
    }

    private void Init() {
        lvBook = findViewById(R.id.lvBookComic);
//        bookClsList.add(new BookCls("test 1", "", "Author 1", 4));
//        bookClsList.add(new BookCls("test 2", "", "Author 2", 2));
//        bookClsList.add(new BookCls("test 3", "", "Author 3", 3));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }
}