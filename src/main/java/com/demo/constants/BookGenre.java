package com.demo.constants;

public enum BookGenre {
    ART("0"),
    BIOGRAPHY("1"),
    CHILDREN("2"),
    FICTION("3"),
    HISTORY("4"),
    MYSTERY("5"),
    PHILOSOPHY("6"),
    RELIGION("7"),
    ROMANCE("8"),
    SELF_HELP("9"),
    TECHNICAL("10");

    private final String genre;

    private BookGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }
}
