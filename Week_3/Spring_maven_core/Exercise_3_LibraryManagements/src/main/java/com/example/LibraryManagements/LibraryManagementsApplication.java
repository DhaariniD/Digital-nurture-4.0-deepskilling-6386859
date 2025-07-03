package com.example.LibraryManagements;

//import com.example.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementsApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       // BookService bookService = (BookService) context.getBean("bookService");
       // bookService.addBook("Spring in Action");
    }
}
