package com.hust;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Library {
    private String libraryName;
    private ArrayList<Book> bookList =new  ArrayList<Book>();

    private static int numberOfBooks = 0;
    public static final int MAX_NUMBER_OF_BOOKS = 100;

    public Library(String libraryName) {
        this.libraryName = libraryName;
    }
    public void addNewBook(){
        System.out.println("Enter book's information:");
        Scanner scan = new Scanner(System.in);
        System.out.println("(1) Book ID:");
        int bookID = scan.nextInt();
        System.out.println("(2) Book Title:");
        scan.nextLine();
        String bookTitle = scan.nextLine();
        System.out.println("(3) Amount:");
        int amount = scan.nextInt();
        if(amount + this.numberOfBooks <= this.MAX_NUMBER_OF_BOOKS) {
            if(bookList.isEmpty() ){
                Library.numberOfBooks += amount;
                bookList.add(new Book(bookID, bookTitle, amount));
            }
            else{
                int count = 0;
                for(Book book: bookList){
                    if(book.getBookID() == bookID){
                        book.setAmount(book.getAmount() + amount);
                        book.setAvailable(book.getAvailable() + amount);
                        Library.numberOfBooks += amount;
                        count ++;
                    }
                }
                if(count == 0){
                    Library.numberOfBooks += amount;
                    bookList.add(new Book(bookID, bookTitle, amount));
                }
            }
        }
    }
    public boolean findBook(int bookID){
        for(Book book: bookList){
            if(book.getBookID()==bookID){
                book.showBookInfo();
                return true;
            }
        }
        return false;
    }
    public void borrowBook(int bookID){
        if(findBook(bookID)){
            for(Book book:bookList){
                if(book.getBookID() == bookID){
                    if(book.getAvailable() > 0){
                        book.setAvailable(book.getAvailable() - 1);
                        this.numberOfBooks--;
                        System.out.println("The book is borrowed successfully!");
                        book.showBookInfo();
                    }
                    else{
                        System.out.println("Sach nay hien tai da muon het!");
                    }
                }
            }
        }
        else{
            System.out.println("Trong thu vien hien khong co loai sach nay!");
        }
    }
    public void returnBook(int bookID){
        for(Book book:bookList){
            if(book.getBookID() == bookID){
                book.setAvailable(book.getAvailable() + 1);
                this.numberOfBooks++;
                System.out.println("The book is returned successfully!");
                book.showBookInfo();
            }
        }
    }
    public void showLibraryInfo(){
        System.out.println("Library Name:" + this.libraryName);
        System.out.println("Number of BOOKS:" + Library.numberOfBooks);
        for(Book book: bookList){
            System.out.println(book.getBookTitle());
        }
    }
    public boolean findBook(String keyword){
        int count = 0;
        for(Book book: bookList){
            if(book.getBookTitle().toLowerCase().indexOf(keyword.toLowerCase()) != -1){
                System.out.println(book.getBookTitle());
                count ++;
            }
        }
        if(count != 0){
            return true;
        }
        return false;
    }
    public Book getALuckyBook(){
        Random rand = new Random();
        while(true) {
            int option = rand.nextInt(100) + 1;
            for(Book book: bookList){
                if(book.getAvailable() == option){
                    return book;
                }
            }
        }
    }
}
