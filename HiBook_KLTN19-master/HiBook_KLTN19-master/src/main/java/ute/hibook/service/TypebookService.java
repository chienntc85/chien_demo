package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.TypebookDTO;

public interface TypebookService {

	public void addTypebook(TypebookDTO typebookDTO);
	public void updateTypebook(TypebookDTO typebookDTO);
	public void deleteTypebook(int idTypebook);
	public TypebookDTO getTypebookById(int idTypebook);
	public List<TypebookDTO> getAllTypebook();
}
