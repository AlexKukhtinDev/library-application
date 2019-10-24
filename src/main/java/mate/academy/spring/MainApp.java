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
import mate.academy.spring.service.LibraryService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Book piu_piu = new Book("PIU PIU", 2019, 121212D, new ArrayList<>());
        Book wiu_wui = new Book("Wiu Wui", 2019, 140D, new ArrayList<>());
        Book shikSki = new Book("ShikSki", 2019, 500D, new ArrayList<>());

        Author stepanBeep = new Author("Stepan", "Beep", new ArrayList<>());
        Author gorikOmar = new Author("Gorik", "Omar", new ArrayList<>());

        User sunilBora =
                new User("Sunil", "Bora", "suni.bora@example.com");
        User davidMiller =
                new User("David", "Miller", "david.miller@example.com");
        User sanchesMiller =
                new User("Sanches", "Miller", "david.miller@example.com");
        User paulSmith =
                new User("Paul", "Smith", "paul.smith@example.com");

        UserService userService = context.getBean(UserService.class);

        // Add Users
        userService.add(sunilBora);
        userService.add(davidMiller);
        userService.add(sanchesMiller);
        userService.add(paulSmith);

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
        bookService.add(wiu_wui);
        bookService.add(piu_piu);
        bookService.add(shikSki);

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
        authorService.add(stepanBeep);
        authorService.add(gorikOmar);

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
        Rent sunilBoraRent = new Rent(localDate, sunilBora, piu_piu);
        Rent davidMillerRent = new Rent(localDate, davidMiller, shikSki);

        // Add Rents
        rentService.add(sunilBoraRent);
        rentService.add(davidMillerRent);

        // Get Rents
        List<Rent> rents = rentService.listRents();
        for (Rent rent : rents) {
            System.out.println("Id = " + rent.getId());
            System.out.println("Date = " + rent.getRentDate());
            System.out.println("Title = " + rent.getBook().getTitle());
            System.out.println("User name = " + rent.getUser().getFirstName());
            System.out.println();
        }
        LibraryService libraryService = context.getBean(LibraryService.class);
        List<Book> bookss = libraryService.getBooksRentedByUser(sunilBora);
        for (Book book: bookss) {
            System.out.println("Id = " + book.getBookId());
            System.out.println("Title = " + book.getTitle());
            System.out.println("Year = " + book.getYear());
            System.out.println("Price = " + book.getPrice());
            System.out.println();
        }

        context.close();
    }
}
