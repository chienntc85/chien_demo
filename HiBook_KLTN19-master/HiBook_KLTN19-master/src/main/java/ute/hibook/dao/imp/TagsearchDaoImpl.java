package ute.hibook.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.ResultSetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.TagsearchDao;
import ute.hibook.entity.Tagsearch;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class TagsearchDaoImpl implements TagsearchDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addTag(Tagsearch tag) {
		sessionFactory.getCurrentSession().save(tag);
	}

	public void updateTag(Tagsearch tag) {
		sessionFactory.getCurrentSession().merge(tag);
	}

	public void deleteTag(int idTag) {
		sessionFactory.getCurrentSession().delete(getTagById(idTag));
	}

	public Tagsearch getTagById(int idTag) {
		return sessionFactory.getCurrentSession().get(Tagsearch.class, idTag);
	}

	public List<Tagsearch> getTagHotLimit() {
		Session session=sessionFactory.getCurrentSession();
		ProcedureCall query= session.createStoredProcedureCall("getTagSearchLimit",Tagsearch.class);
		ResultSetOutput resultSetOutput = (ResultSetOutput) query.getOutputs().getCurrent();
		List<Tagsearch> tagSearchs=resultSetOutput.getResultList();
		return tagSearchs;
	}

	public List<Tagsearch> getAllTag() {
		List<Tagsearch> tagSearchs=sessionFactory.getCurrentSession().createQuery("from tagsearch").getResultList();
		return tagSearchs;
	}

}
