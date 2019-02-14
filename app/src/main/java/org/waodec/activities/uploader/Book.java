package org.waodec.activities.uploader;

public class Book {
    private int bookId;
    private String bookName;
    private int totalCopies;
    private int takenCopies;
    private String writer;

    public Book() {
    }

    public Book(String bookName, int totalCopies, int takenCopies, String writer) {
        this.bookName = bookName;
        this.totalCopies = totalCopies;
        this.takenCopies = takenCopies;
        this.writer = writer;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getTakenCopies() {
        return takenCopies;
    }

    public void setTakenCopies(int takenCopies) {
        this.takenCopies = takenCopies;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", totalCopies=" + totalCopies +
                ", takenCopies=" + takenCopies +
                ", writer='" + writer + '\'' +
                '}';
    }
}
