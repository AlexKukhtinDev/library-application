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

    @Transactional
    @Override
    public void add(Rent rent) {
    rentDao.add(rent);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Rent> listRents() {
        return rentDao.listRents();
    }

    @Override
    public Rent rentBook(User user, Book book) {
        Rent rent = new Rent(LocalDate.now(),user,book);
        rentDao.add(rent);
        return rent;
    }
}
