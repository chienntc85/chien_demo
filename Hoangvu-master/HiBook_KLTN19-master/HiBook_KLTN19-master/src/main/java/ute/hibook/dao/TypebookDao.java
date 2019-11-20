package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.Typebook;

public interface TypebookDao {

	public void addTypebook(Typebook typebook);
	public void updateTypebook(Typebook typebook);
	public void deleteTypebook(int idTypebook);
	public Typebook getTypebookById(int idTypebook);
	public List<Typebook> getAllTypebook();
}
