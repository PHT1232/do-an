package com.example.appquanlyhoctap.Model;

import android.graphics.drawable.Drawable;

public class Item {
    private Drawable imageView;
    private int imageView1;
    private String text;

    public Item(int ic_account_box_black_24dp, String phat) {
        this.imageView1 = ic_account_box_black_24dp;
        this.text = phat;
    }

    public Item(Drawable imageView, String text) {
        this.imageView = imageView;
        this.text = text;
    }

    public int getImageView1() {
        return imageView1;
    }

    public void setImageView1(int imageView1) {
        this.imageView1 = imageView1;
    }

    public Drawable getImageView() {
        return imageView;
    }

    public void setImageView(Drawable imageView) {
        this.imageView = imageView;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
