package com.example.readcomic;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<PageCls> pageCls;

    public PageAdapter(Context context, int layout, List<PageCls> pageCls) {
        this.context = context;
        this.layout = layout;
        this.pageCls = pageCls;
    }

    @Override
    public int getCount() {
        return pageCls.size();
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
        ImageView imgPage = view.findViewById(R.id.imgPage);
        PageCls cls = pageCls.get(i);
        imgPage.setImageBitmap(ConvertBase64String.convertToBimap(cls.getImage()));
        return view;
    }
}
