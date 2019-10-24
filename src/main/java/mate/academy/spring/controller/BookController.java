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

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBooks(ModelMap model) {
        model.put("books", bookService.listBooks());
        return "allBooks";
    }

    @GetMapping("/{bookId}")
    public String bookInfo(@PathVariable("bookId") Long id, ModelMap model) {
        model.put("book", bookService.getById(id));
        return "info";
    }

    @GetMapping("/find")
    public String findBook(@RequestParam("title") String name, ModelMap model) {
        model.put("books", bookService.findByName(name));
        return "allBooks";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, ModelMap model) {
        model.put("book", bookService.add(book));
        return getAllBooks(model);
    }
}
