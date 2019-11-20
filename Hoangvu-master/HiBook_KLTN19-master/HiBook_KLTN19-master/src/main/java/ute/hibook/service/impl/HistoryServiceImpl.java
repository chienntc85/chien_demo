package ute.hibook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.HistoryDao;
import ute.hibook.dao.imp.HistoryDaoImpl;
import ute.hibook.entity.History;
import ute.hibook.entity.User;

@Service
public class HistoryServiceImpl implements HistoryDao{
	
	@Autowired
	HistoryDaoImpl historyDaoImpl;

	public void addHistory(History history) {
		// TODO Auto-generated method stub
		historyDaoImpl.addHistory(history);
		System.out.println("successful");
		
	}

	public void deleteUser(int idUserHistory) {
		
		historyDaoImpl.deleteUser(idUserHistory);			
			System.out.println("delete User successful!");
	}

	public History getidUserHistoryByidBook(int idBook) {
		History his=historyDaoImpl.getidUserHistoryByidBook(idBook);
		return his;
	
				
	}

	public List<History> getAllHistory() {
		return historyDaoImpl.getAllHistory();
	}

	public List<History> getHistoryByidUser(int idUser) {
		return historyDaoImpl.getHistoryByidUser(idUser);
	}

}
