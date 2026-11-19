package org.example.model;

public enum Category {
    FOOD(1),
    RENT(2),
    OTHER(3);

    private final int code;

    Category(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
