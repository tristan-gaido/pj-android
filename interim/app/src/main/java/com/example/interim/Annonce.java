package com.example.interim;

public class Annonce {
    private String title;
    private String description;
    private String date;
    private int imageResourceId;

    public Annonce(String title, String description, String date, int imageResourceId) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.imageResourceId = imageResourceId;
    }

    // Getters et Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
