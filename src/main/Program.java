package main;

import com.hust.Book;
import com.hust.Library;

import java.util.Scanner;

public class Program {
    public static Scanner scan = new Scanner(System.in);
    private static int option;
    public static void showMenu(){
        System.out.println("============Main Menu============");
        System.out.println("1. Show Library Information");
        System.out.println("2. Add new Book");
        System.out.println("3. Find Book");
        System.out.println("4. Borrow a Book");
        System.out.println("5. Return a Book");
        System.out.println("6. Exit");
        System.out.println("=================================");
        System.out.println("Enter menu ID (1-6)");
    }
    public static void askOption(){
        System.out.println("Enter your Option:");
        option = scan.nextInt();
    }
    public static void main(String[] args) {
        Library TQB = new Library("TA QUANG BUU");

        while(true){
            showMenu();
            askOption();
            switch (option){
                case 1:{
                    TQB.showLibraryInfo();
                    break;
                }
                case 2:{
                    TQB.addNewBook();
                    break;
                }
                case 3: {
                    System.out.println("Vui long nhap bookID");
                    int bookID = scan.nextInt();
                    if(TQB.findBook(bookID)){
                        System.out.println("Co cuon sach nay trong thu vien!");
                    }
                    else{
                        System.out.println("Khong co cuon sach nay trong thu vien");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Vui long nhap BookID:");
                    int bookID = scan.nextInt();
                    TQB.borrowBook(bookID);
                    break;
                }
                case 5: {
                    System.out.println("Vui ong nhap Book ID:");
                    int bookID = scan.nextInt();
                    TQB.returnBook(bookID);
                    break;
                }
                case 6: {
                    System.exit(0);
                }
                default:
                    System.out.println("Wrong chose!");
            }
        }
    }
}
