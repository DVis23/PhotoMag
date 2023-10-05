package ru.vsu.cs;

public abstract class Tool {
    private final String id;

    protected Tool(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}
