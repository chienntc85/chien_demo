package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.TagsearchDaoImpl;
import ute.hibook.dto.TagsearchDTO;
import ute.hibook.entity.Tagsearch;
import ute.hibook.service.TagsearchService;

@Service
public class TagsearchServiceImpl implements TagsearchService{

	@Autowired
	TagsearchDaoImpl tagDao;
	
	String CATEGORY = "TỪ KHÓA HOT";
	
	public void addTag(TagsearchDTO tagDTO) {
		//check tag exists, if exists num++, not exists add new tag 
		List<Tagsearch> tags = tagDao.getAllTag();
		for (Tagsearch tagsearch : tags) {
			//exists not add
			if(tagsearch.getNameTag().trim().equals(tagDTO.getValue().trim())) {
				return;
			}
		}
		//not exists, add into table tag
		Tagsearch tag=new Tagsearch();
		tag.setNameTag(tagDTO.getValue().trim());
		tag.setNumOfSearch(tagDTO.getNumOfSearch());
		tagDao.addTag(tag);
		System.out.println("add Tagseach successful!");
	}

	public void updateTag(TagsearchDTO tagDTO) {
		Tagsearch tag= tagDao.getTagById(tagDTO.getIdTag());
		if(tag!=null) {
			tag.setNameTag(tagDTO.getValue().trim());
			tag.setNumOfSearch(tagDTO.getNumOfSearch());
			tagDao.updateTag(tag);
			System.out.println("update Tagseach successful!");
		}
//		Tagsearch tag = tagDao.getTagById(tagsearch.getIdTag());
//		tag.setNumOfSearch(tag.getNumOfSearch()+1);
//		tagDao.updateTag(tag);
//		System.out.println("update Tagseach successful!");
	}

	public void deleteTag(int idTag) {
		Tagsearch tag= tagDao.getTagById(idTag);
		if(tag!=null) {
			tagDao.deleteTag(idTag);
			System.out.println("delete Tagseach successful!");
		}
	}

	public TagsearchDTO getTagById(int idTag) {
		Tagsearch tag= tagDao.getTagById(idTag);
		
		TagsearchDTO tagDTO= new TagsearchDTO();
		tagDTO.setIdTag(tag.getIdTag());
		tagDTO.setValue(tag.getNameTag());
		tagDTO.setNumOfSearch(tag.getNumOfSearch());
		
		return tagDTO;
	}

	public List<TagsearchDTO> getAllTag() {
		List<Tagsearch> lstTag= tagDao.getAllTag();
		
		List<TagsearchDTO> lstTagDTO= new ArrayList<TagsearchDTO>();
		for (Tagsearch tag : lstTag) {
			
			TagsearchDTO tagDTO= new TagsearchDTO();
			tagDTO.setIdTag(tag.getIdTag());
			tagDTO.setValue(tag.getNameTag());
			tagDTO.setNumOfSearch(tag.getNumOfSearch());
			tagDTO.setCategory("");
		
			lstTagDTO.add(tagDTO);
		}
		return lstTagDTO;
	}

	public List<TagsearchDTO> getTagHotLimit() {
		List<Tagsearch> lstTag= tagDao.getTagHotLimit();
		
		List<TagsearchDTO> lstTagDTO= new ArrayList<TagsearchDTO>();
		for (Tagsearch tag : lstTag) {
			
			TagsearchDTO tagDTO= new TagsearchDTO();
			tagDTO.setIdTag(tag.getIdTag());
			tagDTO.setValue(tag.getNameTag());
			tagDTO.setNumOfSearch(tag.getNumOfSearch());
			tagDTO.setCategory(CATEGORY);
		
			lstTagDTO.add(tagDTO);
		}
		return lstTagDTO;
	}

}
