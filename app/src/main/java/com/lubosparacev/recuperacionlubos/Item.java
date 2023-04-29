package com.lubosparacev.recuperacionlubos;

public class Item {
    private int imageResourceId;
    private String title;

    public Item(int imageResourceId, String title) {
        this.imageResourceId = imageResourceId;
        this.title = title;
    }

    public int getImageResource() {
        return imageResourceId;
    }

    public String getTitle() {
        return title;
    }
}
