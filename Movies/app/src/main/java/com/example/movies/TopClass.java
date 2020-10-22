package com.example.movies;

public class TopClass {
    int img;
    String text,hours,minute;


    public TopClass(int img, String text, String hours, String minute) {
        this.img = img;
        this.text = text;
        this.hours = hours;
        this.minute = minute;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
