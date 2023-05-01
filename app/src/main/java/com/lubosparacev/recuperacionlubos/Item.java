package com.lubosparacev.recuperacionlubos;

public class Item {
    private String title;
    private String image;
    private String description;

    public Item(String title, String image, String description) {
        this.title = title;
        this.image = image;
        this.description = description;
    }

    public String getTitle() { return title; }

    public String getImage() { return image; }

    public String getDescription() { return description; }
}
