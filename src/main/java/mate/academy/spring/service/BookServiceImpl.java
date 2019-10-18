package mate.academy.spring.service;

import mate.academy.spring.dao.BookDao;
import mate.academy.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookDao bookDao;

    @Transactional
    @Override
    public void add(Book book) {
    bookDao.add(book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }
}
