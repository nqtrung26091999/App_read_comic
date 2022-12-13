package com.example.readcomic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookCls {
    @SerializedName("BOOK_ID")
    @Expose
    private int bookId;
    @SerializedName("BOOK_NAME")
    @Expose
    private String bookName;
    @SerializedName("BOOK_COVER")
    @Expose
    private String bookCover;
    @SerializedName("BOOK_AUTHOR")
    @Expose
    private String bookAuthor;
    @SerializedName("BOOK_RATTING")
    @Expose
    private int ratting;

    public BookCls(String bookName, String bookCover, String bookAuthor, int ratting) {
        this.bookName = bookName;
        this.bookCover = bookCover;
        this.bookAuthor = bookAuthor;
        this.ratting = ratting;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getRatting() {
        return ratting;
    }

    public void setRatting(int ratting) {
        this.ratting = ratting;
    }
}
