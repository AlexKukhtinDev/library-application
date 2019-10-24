package mate.academy.spring.dao;

import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class LibraryDaoImpl implements LibraryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Rent rentBook(User user, Book book) {
        Rent rent = new Rent(LocalDate.now(),user, book);
        sessionFactory.getCurrentSession().save(rent);
        return rent;
    }

    @Override
    public Rent getRent(User user, Book book) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent WHERE user.id = :userId " +
                        "AND book.id = :bookId", Rent.class);
        query.setParameter("userId", user.getId());
        query.setParameter("bookId", book.getBookId());
        return query.getSingleResult();
    }

    @Override
    public void returnBook(Rent rent) {
        rent.setActive(false);
        sessionFactory.getCurrentSession().update(rent);
    }

    @Override
    public List<Book> getBooksRentedByUser(User user) {
        TypedQuery<Book> query = sessionFactory.getCurrentSession()
                .createQuery("select book from Rent where user_id = :user_id and active = true",
                        Book.class);
        query.setParameter("user_id", user.getId());
        return query.getResultList();
    }
}
