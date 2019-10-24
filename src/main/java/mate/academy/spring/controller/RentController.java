package mate.academy.spring.controller;

import mate.academy.spring.entity.Rent;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rent")
public class RentController {
    private static final Long USER_ID = 1L;

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private RentService rentService;

    @GetMapping("/rentBook")
    public String rentBook(@RequestParam("book_id") Long id, ModelMap model) {
        model.put("book", rentService.rentBook(userService.getById(USER_ID),
                bookService.getById(id)));
        return "forward:/book";
    }

    @GetMapping("/returnBook")
    public String returnBook(@RequestParam("book_id") Long id) {
        Rent rent = rentService.getRent(userService.getById(USER_ID),
                bookService.getById(id));
        rentService.returnBook(rent);
        return "forward:/book";
    }

    @GetMapping("/rentedBooks")
    public String getBooksRentedByUser(ModelMap model) {
        model.addAttribute("books",
                rentService.getBooksRentedByUser(userService.getById(USER_ID)));
        return "usersRentedBooks";
    }
}
