package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.Tagsearch;

public interface TagsearchDao {

	public void addTag(Tagsearch tag);
	public void updateTag(Tagsearch tag);
	public void deleteTag(int idTag);
	public Tagsearch getTagById(int idTag);
	public List<Tagsearch> getAllTag();
	public List<Tagsearch> getTagHotLimit();
}
