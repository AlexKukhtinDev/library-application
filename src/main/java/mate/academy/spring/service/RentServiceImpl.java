package mate.academy.spring.service;

import java.time.LocalDate;
import java.util.List;
import mate.academy.spring.dao.RentDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentDao rentDao;

    @Override
    public void add(Rent rent) {
    rentDao.add(rent);
    }

    @Override
    public List<Rent> listRents() {
        return rentDao.listRents();
    }

    @Transactional
    @Override
    public Rent rentBook(User user, Book book) {
        return rentDao.rentBook(user, book);
    }

    @Transactional
    @Override
    public Rent getRent(User user, Book book) {
        return rentDao.getRent(user, book);
    }

    @Transactional
    @Override
    public void returnBook(Rent rent) {
        rentDao.returnBook(rent);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooksRentedByUser(User user) {
        return rentDao.getBooksRentedByUser(user);
    }

}
