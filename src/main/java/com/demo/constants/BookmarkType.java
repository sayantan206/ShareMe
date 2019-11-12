package com.demo.constants;

public enum BookmarkType {
    Book(0),
    Movie(1),
    WebLink(2),
    WebSeries(3);

    private final int typeId;

    private BookmarkType(int typeId) {
        this.typeId = typeId;
    }

    public int getTypeId() {
        return this.typeId;
    }
}
