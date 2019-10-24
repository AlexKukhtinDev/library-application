package mate.academy.spring.dao;

import java.util.List;

import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;

public interface RentDao {

    void add(Rent rent);

    List<Rent> listRents();

    Rent rentBook(User user, Book book);

    Rent getRent(User user, Book book);

    void returnBook(Rent rent);

    List<Book> getBooksRentedByUser(User user);

}
