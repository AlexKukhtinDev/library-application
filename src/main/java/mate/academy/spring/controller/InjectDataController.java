package mate.academy.spring.controller;

import java.util.ArrayList;
import mate.academy.spring.config.AppConfig;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.AuthorService;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/injectData")
public class InjectDataController {
    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String injectData() {
        Book eccel = new Book("Filosofiya",2015,1200D);
            bookService.add(eccel);
        Book shildt = new Book("СompleteGuide", 2015, 900D);
            bookService.add(shildt);
        Book bloch = new Book("EffectiveJava", 2015, 1400D);
            bookService.add(bloch);
            return "forward:";
    }

}
