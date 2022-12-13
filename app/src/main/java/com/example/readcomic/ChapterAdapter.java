package com.example.readcomic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ChapterAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ChapterCls> chapterClsList;

    public ChapterAdapter(Context context, int layout, List<ChapterCls> chapterClsList) {
        this.context = context;
        this.layout = layout;
        this.chapterClsList = chapterClsList;
    }

    @Override
    public int getCount() {
        return chapterClsList.size();
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
        TextView tvChapter = view.findViewById(R.id.tvChapter);
        ChapterCls chapterCls = chapterClsList.get(i);
        tvChapter.setText(chapterCls.getChapterName());
        tvChapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PageChapterActivity.class);
                intent.putExtra("CHAPTER_ID", chapterCls.getChapterId());
                context.startActivity(intent);
            }
        });
        return view;
    }
}
