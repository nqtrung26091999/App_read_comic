package com.example.readcomic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PageCls {
    @SerializedName("PAGE_ID")
    @Expose
    private int id;
    @SerializedName("PAGE_NUMBER")
    @Expose
    private int pageNumber;
    @SerializedName("PAGE_IMAGE")
    @Expose
    private String image;
    @SerializedName("CHAPTER_ID")
    @Expose
    private int chapterId;

    public PageCls(int id, int pageNumber, String image, int chapterId) {
        this.id = id;
        this.pageNumber = pageNumber;
        this.image = image;
        this.chapterId = chapterId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }
}
