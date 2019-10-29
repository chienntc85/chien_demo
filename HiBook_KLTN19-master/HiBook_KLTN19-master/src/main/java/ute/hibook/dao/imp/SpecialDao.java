package ute.hibook.dao.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.ResultSetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import ute.hibook.entity.Book;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SpecialDao {

	@Autowired
	SessionFactory sessionFactory;

	/* GET Book limit num, begin from number location book*/
	@Transactional
	public List<Book> getBookLimit(int begin, int num) {
			Session session=sessionFactory.getCurrentSession();
			List<Book> lstBook=new ArrayList<Book>();
			lstBook=session.createQuery("from book").setFirstResult(begin).setMaxResults(num).getResultList();
			return lstBook;
	}
	
	/*Best selling books *///-1 get all
	@Transactional
	public List<Book> getBestSellBooks() {
			Session session=sessionFactory.getCurrentSession();
			ProcedureCall query= session.createStoredProcedureCall("getNumBooksSold",Book.class);
			query.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(-1);
			query.registerParameter(2, Integer.class, ParameterMode.IN).bindValue(0);
			ResultSetOutput resultSetOutput = (ResultSetOutput) query.getOutputs().getCurrent();
			List<Book> lstBook=resultSetOutput.getResultList();
			return lstBook;
	}
	
	/*Best selling books limit*/
	@Transactional
	public List<Book> getBestSellBooksLimit(int offsets, int limits) {
			Session session=sessionFactory.getCurrentSession();
			ProcedureCall query= session.createStoredProcedureCall("getNumBooksSold",Book.class);
			query.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(offsets);
			query.registerParameter(2, Integer.class, ParameterMode.IN).bindValue(limits);
			ResultSetOutput resultSetOutput = (ResultSetOutput) query.getOutputs().getCurrent();
			List<Book> lstBook=resultSetOutput.getResultList();
			return lstBook;
	}
	
	/*New books *///-1 get all
	@Transactional
	public List<Book> getNewBooks() {
			Session session=sessionFactory.getCurrentSession();
			ProcedureCall query= session.createStoredProcedureCall("getNewPublicationDate",Book.class);
			query.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(-1);
			query.registerParameter(2, Integer.class, ParameterMode.IN).bindValue(0);
			ResultSetOutput resultSetOutput = (ResultSetOutput) query.getOutputs().getCurrent();
			List<Book> lstBook=resultSetOutput.getResultList();
			return lstBook;
	}
	/*New books Limit*/
	@Transactional
	public List<Book> getNewBooksLimit(int offsets, int limits) {
			Session session=sessionFactory.getCurrentSession();
			ProcedureCall query= session.createStoredProcedureCall("getNewPublicationDate",Book.class);
			query.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(offsets);
			query.registerParameter(2, Integer.class, ParameterMode.IN).bindValue(limits);
			ResultSetOutput resultSetOutput = (ResultSetOutput) query.getOutputs().getCurrent();
			List<Book> lstBook=resultSetOutput.getResultList();
			return lstBook;
	}
	
}
