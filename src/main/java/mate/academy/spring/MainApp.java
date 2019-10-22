package mate.academy.spring;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import mate.academy.spring.config.AppConfig;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.AuthorService;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Book book1 = new Book("PIU PIU", 2019, 121212D, new ArrayList<>());
        Book book2 = new Book("Wiu Wui", 2019, 140D, new ArrayList<>());
        Book book3 = new Book("ShikSki", 2019, 500D, new ArrayList<>());

        Author author1 = new Author("Stepan", "Beep", new ArrayList<>());
        Author author2 = new Author("Gorik", "Omar", new ArrayList<>());

        book1.getAuthors().add(author1);
        book2.getAuthors().add(author1);
        book3.getAuthors().add(author2);

        author1.getBooks().add(book1);
        author1.getBooks().add(book2);
        author2.getBooks().add(book3);

        User user1 =
                new User("Sunil", "Bora", "suni.bora@example.com");
        User user2 =
                new User("David", "Miller", "david.miller@example.com");
        User user3 =
                new User("David", "Miller", "david.miller@example.com");
        User user4 =
                new User("Paul", "Smith", "paul.smith@example.com");

        UserService userService = context.getBean(UserService.class);

        // Add Users
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        // Get Users
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        BookService bookService = context.getBean(BookService.class);

        // Add Books
        bookService.add(book1);
        bookService.add(book2);
        bookService.add(book3);

        // Get Books
        List<Book> books = bookService.listBooks();
        for (Book book : books) {
            System.out.println("Id = " + book.getBookId());
            System.out.println("Title = " + book.getTitle());
            System.out.println("Year = " + book.getYear());
            System.out.println("Price = " + book.getPrice());
            System.out.println();
        }

        List<Book> bookByTitle = bookService.findByTitle("PIU PIU");
        for (Book book : bookByTitle) {
            System.out.println("Id = " + book.getBookId());
            System.out.println("Title = " + book.getTitle());
            System.out.println("Year = " + book.getYear());
            System.out.println("Price = " + book.getPrice());
            System.out.println();
        }

        AuthorService authorService = context.getBean(AuthorService.class);

        // Add Authors
        authorService.add(author1);
        authorService.add(author2);

        // Get Authors
        List<Author> authors = authorService.listAuthors();
        for (Author author : authors) {
            System.out.println("Id = " + author.getId());
            System.out.println("Title = " + author.getName());
            System.out.println("Year = " + author.getSurname());
            System.out.println();
        }

        List<Author> authorByName = authorService.findByName("Gorik");
        for (Author author : authorByName) {
            System.out.println("Id = " + author.getId());
            System.out.println("Title = " + author.getName());
            System.out.println("Year = " + author.getSurname());
            System.out.println();
        }

        RentService rentService = context.getBean(RentService.class);

        LocalDate localDate = LocalDate.now();
        Rent rent1 = new Rent(localDate, user1, book1, true);
        Rent rent2 = new Rent(localDate, user2, book3, true);

        // Add Rents
        rentService.add(rent1);
        rentService.add(rent2);

        // Get Rents
        List<Rent> rents = rentService.listRents();
        for (Rent rent : rents) {
            System.out.println("Id = " + rent.getId());
            System.out.println("Date = " + rent.getRentDate());
            System.out.println("Title = " + rent.getBook().getTitle());
            System.out.println("User name = " + rent.getUser().getFirstName());
            System.out.println();
        }

        context.close();
    }
}
