package mate.academy.spring.service;

import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;

import java.util.List;

public interface LibraryService {

    Rent rentBook(User user, Book book);

    Rent getRent(User user, Book book);

    void returnBook(Rent rent);

    List<Book> getBooksRentedByUser(User user);
}
