package ute.hibook.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.BookDao;
import ute.hibook.entity.Author;
import ute.hibook.entity.Book;
import ute.hibook.entity.Supplier;
import ute.hibook.entity.Typebook;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class BookDaoImpl implements BookDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addBook(Book book) {
		Session session=sessionFactory.getCurrentSession();
		List<Author> authors=new ArrayList<Author>();
		for (Author author : book.getAuthors()) {
			Author author2=session.get(Author.class, author.getIdAuthor());
			authors.add(author2);
		}
		book.setAuthors(authors);
		Supplier supplier=session.get(Supplier.class,book.getSupplier().getIdSupplier());
		book.setSupplier(supplier);
		Typebook typeBook=session.get(Typebook.class, book.getTypebook().getIdType());
		book.setTypebook(typeBook);
		session.save(book);
	}

	public void updateBook(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}

	public void deleteBook(int idBook) {
		Book book = getBookById(idBook);
		book.setAuthors(null);
		sessionFactory.getCurrentSession().save(book);
		sessionFactory.getCurrentSession().delete(book);
	}

	public Book getBookById(int idBook) {
		return sessionFactory.getCurrentSession().get(Book.class, idBook);
	}

	public List<Book> getAllBook() {
		return sessionFactory.getCurrentSession().createQuery("from book").getResultList();
	}
	
	public List<Book> getBookLimit(int start, int limit) {
		return sessionFactory.getCurrentSession().createQuery("from book").setFirstResult(start).setMaxResults(limit).getResultList();
	}

}