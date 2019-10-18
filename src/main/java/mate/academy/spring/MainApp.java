package mate.academy.spring;

import mate.academy.spring.config.AppConfig;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        // Add Users
        userService.add(
                new User("Sunil", "Bora", "suni.bora@example.com"));
        userService.add(
                new User("David", "Miller", "david.miller@example.com"));
        userService.add(
                new User("Sameer", "Singh", "sameer.singh@example.com"));
        userService.add(
                new User("Paul", "Smith", "paul.smith@example.com"));

        // Get Users
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        Author author = new Author();
        BookService bookService = context.getBean(BookService.class);
        bookService.add(new Book("Shildt",2015,new BigDecimal(900)));
        bookService.add(new Book("Ekkel",2014,new BigDecimal(1200)));

        List<Book>books = bookService.listBooks();
        for (Book book: books) {
            System.out.println(book.getId());
            System.out.println(book.getPrice());
            System.out.println(book.getTitle());
        }



        context.close();
    }
}
