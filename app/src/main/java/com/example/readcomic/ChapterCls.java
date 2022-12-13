package com.example.readcomic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChapterCls {
    @SerializedName("CHAPTER_ID")
    @Expose
    private int chapterId;
    @SerializedName("CHAPTER_NAME")
    @Expose
    private String chapterName;
    @SerializedName("BOOK_ID")
    @Expose
    private int bookId;

    public ChapterCls(int chapterId, String chapterName, int bookId) {
        this.chapterId = chapterId;
        this.chapterName = chapterName;
        this.bookId = bookId;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
