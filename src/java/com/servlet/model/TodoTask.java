package com.servlet.model;

public class TodoTask {
    private int id;

    private String title;
    private String content;
    private boolean done;

    public TodoTask(){}

    public TodoTask(int id, String title, String content, boolean done) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
