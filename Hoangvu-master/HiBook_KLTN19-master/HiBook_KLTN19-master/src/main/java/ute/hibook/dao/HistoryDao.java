package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.History;
import ute.hibook.entity.User;

public interface HistoryDao {
	public void addHistory(History history);
	public void deleteUser(int idUserHistory);
	public History getidUserHistoryByidBook(int idBook);
	public List<History> getAllHistory();
	public List<History> getHistoryByidUser(int idUser);
}
