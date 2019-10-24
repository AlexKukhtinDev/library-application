package mate.academy.spring.service;

import java.util.List;

import mate.academy.spring.dao.BookDao;
import mate.academy.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public Book add(Book book) {
        bookDao.add(book);
        return book;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByTitle(String title) {
        return bookDao.findByTitle(title);
    }

    @Transactional(readOnly = true)
    @Override
    public Book getById(Long id) {
        return bookDao.getById(id);
        }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByName(String name) {
        return bookDao.findByName(name);
    }
}

