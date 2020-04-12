package com.hust;

public class Book {
    private int bookID;
    private String bookTitle;
    private int amount;
    private int available;

    public Book() {
    }
    public Book(int bookID, String bookTitle, int amount){
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.amount = amount;
        this.available = amount;
    }
    public void showBookInfo(){
        System.out.println("Book ID:" + this.bookID);
        System.out.println("Book Title:" + this.bookTitle);
        System.out.println("Total amount:" + this.amount);
        System.out.println("Available:" + this.available);
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
