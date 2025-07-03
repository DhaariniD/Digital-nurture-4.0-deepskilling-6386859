package com.example;
import com.example.service.BookService;
//import com.example.repository.BookRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("Configuring a Basic Spring Application");

        // Load Spring context from XML
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get BookService bean
        BookService bookService = (BookService) context.getBean("bookService");
        //BookRepository bookServices = (BookRepository) context.getBean("bookServices");


        // Use it
        //System.out.println("Configuring a Basic Spring Application");
        bookService.addBook("Spring in Action");
        //bookServices.save("Spring in Action");
    }
}
