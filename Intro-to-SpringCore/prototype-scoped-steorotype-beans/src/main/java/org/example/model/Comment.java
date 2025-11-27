package org.example.model;

public class Comment {
    private final int Id;
    private final String text;

    public Comment(int id, String text) {
        Id = id;
        this.text = text;
    }

    public int getId() {
        return Id;
    }

    public String getText() {
        return text;
    }
}
