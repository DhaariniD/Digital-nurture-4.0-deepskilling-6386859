package com.example.repository;

public class BookRepository {
    public void save(String bookName) {
        System.out.println("BookRepository: Book '" + bookName + "' saved to database.");
    }
}
