package org.waodec.activities.uploader;

public class Borrower {

    private Book book;

    private RegisterClient registerClient;

    private String receiveDate;
    private String returnDate;

    public Borrower() {
    }

    public Borrower(Book book, RegisterClient registerClient, String receiveDate, String returnDate) {
        this.book = book;
        this.registerClient = registerClient;
        this.receiveDate = receiveDate;
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public RegisterClient getRegisterClient() {
        return registerClient;
    }

    public void setRegisterClient(RegisterClient registerClient) {
        this.registerClient = registerClient;
    }


    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "book=" + book +
                ", registerClient=" + registerClient +
                ", receiveDate='" + receiveDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
