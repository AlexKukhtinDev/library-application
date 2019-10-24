package mate.academy.spring.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import mate.academy.spring.entity.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Book add(Book book) {
        sessionFactory.getCurrentSession().save(book);
        return book;
    }

    @Override
    public List<Book> listBooks() {
        TypedQuery<Book> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Book", Book.class);
        return query.getResultList();
    }

    @Override
    public List<Book> findByTitle(String title) {
        TypedQuery<Book> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Book WHERE title LIKE CONCAT('%', :title, '%')", Book.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Override
    public Book getById(Long id) {
        Book book = sessionFactory.getCurrentSession().get(Book.class,id);
        return book;
    }

    @Override
    public List<Book> findByName(String name) {
        TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery(
                "FROM Book WHERE name LIKE CONCAT('%', :name, '%')", Book.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
