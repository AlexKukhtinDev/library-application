package mate.academy.spring.controller;

import mate.academy.spring.config.AppConfig;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.AuthorService;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/injectData")
public class InjectDataController {
    @GetMapping
    public String injectData() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Add Users
        UserService userService = context.getBean(UserService.class);
        userService.add(new User("Sunil", "Bora", "suni.bora@example.com"));
        userService.add(new User("David", "Miller", "david.miller@example.com"));
        userService.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
        userService.add(new User("Paul", "Smith", "paul.smith@example.com"));

        // Add Authors
        AuthorService authorService = context.getBean(AuthorService.class);
        Author stepanBeep = new Author("Stepan", "Beep", new ArrayList<>());
        authorService.add(stepanBeep);
        Author gorikOmar = new Author("Gorik", "Omar", new ArrayList<>());
        authorService.add(gorikOmar);
        // Add Books
        BookService bookService = context.getBean(BookService.class);
        Book piu_piu = new Book("PIU PIU", 2019, 121212D, new ArrayList<>());
        bookService.add(piu_piu);
        Book wiu_wui = new Book("Wiu Wui", 2019, 140D, new ArrayList<>());
        bookService.add(wiu_wui);
        Book shikSki = new Book("ShikSki", 2019, 500D, new ArrayList<>());
        bookService.add(shikSki);

        context.close();
        return "forward:";
    }
}
