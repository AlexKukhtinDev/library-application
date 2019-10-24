package mate.academy.spring.dao;

import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;

import java.util.List;

public interface LibraryDao {
    Rent rentBook(User user, Book book);

    Rent getRent(User user, Book book);

    void returnBook(Rent rent);

    List<Book> getBooksRentedByUser(User user);
}
