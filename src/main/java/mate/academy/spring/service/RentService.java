package mate.academy.spring.service;

import java.util.List;

import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;

public interface RentService {
    void add (Rent rent);

    List<Rent> listRents();
}
