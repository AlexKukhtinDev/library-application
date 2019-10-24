package mate.academy.spring.service;

import mate.academy.spring.dao.LibraryDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
    public class LibraryServiceImpl implements LibraryService {

        @Autowired
        private LibraryDao libraryDao;

        @Transactional
        @Override
        public Rent rentBook(User user, Book book) {
            return libraryDao.rentBook(user, book);
        }

        @Transactional
        @Override
        public Rent getRent(User user, Book book) {
            return libraryDao.getRent(user, book);
        }

        @Transactional
        @Override
        public void returnBook(Rent rent) {
            libraryDao.returnBook(rent);
        }

        @Transactional(readOnly = true)
        @Override
        public List<Book> getBooksRentedByUser(User user) {
            return libraryDao.getBooksRentedByUser(user);
        }
    }
