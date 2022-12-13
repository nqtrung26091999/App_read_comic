package com.example.readcomic;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<BookCls> bookClsList;

    public BookAdapter(Context context, int layout, List<BookCls> bookClsList) {
        this.context = context;
        this.layout = layout;
        this.bookClsList = bookClsList;
    }

    @Override
    public int getCount() {
        return bookClsList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        ImageView imgBookCover = view.findViewById(R.id.imgBookCover);
        TextView tvBookName = view.findViewById(R.id.tvNameBook);
        TextView tvBookAuthor = view.findViewById(R.id.tvBookAuthor);
        RatingBar rtBook = view.findViewById(R.id.rtBook);
        Button btnReadBook = view.findViewById(R.id.btnReadBook);

        BookCls bookCls = bookClsList.get(i);

        imgBookCover.setImageBitmap(ConvertBase64String.convertToBimap(bookCls.getBookCover()));
        tvBookName.setText(bookCls.getBookName());
        tvBookAuthor.setText(bookCls.getBookAuthor());
        rtBook.setRating(bookCls.getRatting());
        String BOOK_ID = bookCls.getBookId() + "";

        btnReadBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChapterActivity.class);
                intent.putExtra("ID", BOOK_ID);
                context.startActivity(intent);
            }
        });
        return view;
    }
}
