package ute.hibook.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.AuthorDao;
import ute.hibook.entity.Author;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class AuthorDaoImpl implements AuthorDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addAuthor(Author author) {
		sessionFactory.getCurrentSession().save(author);
	}

	public void updateAuthor(Author author) {
		sessionFactory.getCurrentSession().update(author);
	}

	public void deleteAuthor(int idAuthor) {
		sessionFactory.getCurrentSession().delete(getAuthorById(idAuthor));
	}

	public Author getAuthorById(int idAuthor) {
		return sessionFactory.getCurrentSession().get(Author.class, idAuthor);
	}

	public List<Author> getAllAuthor() {
		return sessionFactory.getCurrentSession().createQuery("from author").getResultList();
	}

}
