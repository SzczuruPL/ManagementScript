package com.company;

class Task {
    private String id;
    private String name;
    private int time;

    public Task(String id, String name, int time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }
}