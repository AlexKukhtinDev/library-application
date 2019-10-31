package mate.academy.spring.controller;

import mate.academy.spring.entity.Book;
import mate.academy.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBooks(ModelMap model) {
        model.put("allBooks", bookService.listBooks());
        return "allBooks";
    }

    @GetMapping("/{id}")
    public String bookInfo(@PathVariable Long id, ModelMap model) {
        model.put("book", bookService.get(id));
        return "bookInfo";
    }

    @GetMapping("/find")
    public String findBook(@RequestParam("title") String title, ModelMap model) {
        model.put("allBooks", bookService.findByTitle(title));
        return "allBooks";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Book book, ModelMap model) {
        bookService.add(book);
        return getAllBooks(model);
    }

    @GetMapping("/add")
    public String addBookPage() {
        return "createBook";
    }
}