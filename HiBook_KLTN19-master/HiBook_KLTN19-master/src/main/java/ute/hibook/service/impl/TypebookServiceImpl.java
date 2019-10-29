package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.TypebookDaoImpl;
import ute.hibook.dto.TypebookDTO;
import ute.hibook.entity.Typebook;
import ute.hibook.service.TypebookService;

@Service
public class TypebookServiceImpl implements TypebookService{

	@Autowired
	TypebookDaoImpl typebookDao;
	
	public void addTypebook(TypebookDTO typebookDTO) {
		Typebook typebook= new Typebook();
		typebook.setImgType(typebookDTO.getImgType());
		typebook.setNameType(typebookDTO.getNameType());
		
		typebookDao.addTypebook(typebook);		
		System.out.println("add Typebook successful!");
	}

	public void updateTypebook(TypebookDTO typebookDTO) {
		Typebook typebook= typebookDao.getTypebookById(typebookDTO.getIdType());
		if(typebook!=null) {
			typebook.setImgType(typebookDTO.getImgType());
			typebook.setNameType(typebookDTO.getNameType());
			
			typebookDao.updateTypebook(typebook);
			System.out.println("update Typebook successful!");
		}
	}

	public void deleteTypebook(int idTypebook) {
		Typebook typebook= typebookDao.getTypebookById(idTypebook);
		if(typebook!=null) {
			typebookDao.deleteTypebook(idTypebook);
			System.out.println("delete Typebook successful!");
		}
	}

	public TypebookDTO getTypebookById(int idTypebook) {
		Typebook typebook= typebookDao.getTypebookById(idTypebook);
		
		TypebookDTO typebookDTO= new TypebookDTO();
		typebookDTO.setIdType(typebook.getIdType());
		typebookDTO.setNameType(typebook.getNameType());
		typebookDTO.setImgType(typebook.getImgType());
		//System.out.println(typebook.getBooks().get(0).getNameBook());
		
		return typebookDTO;
	}

	public List<TypebookDTO> getAllTypebook() {
		List<Typebook> lstTypebook= typebookDao.getAllTypebook();
		
		List<TypebookDTO> lstTypebookDTO= new ArrayList<TypebookDTO>();
		for (Typebook typebook : lstTypebook) {
			
			TypebookDTO typebookDTO= new TypebookDTO();
			typebookDTO.setIdType(typebook.getIdType());
			typebookDTO.setNameType(typebook.getNameType());
			typebookDTO.setImgType(typebook.getImgType());
		
			lstTypebookDTO.add(typebookDTO);
		}
		return lstTypebookDTO;
	}
}
