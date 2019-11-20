package ute.hibook.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tagsearch database table.
 * 
 */
@Entity(name="tagsearch")
public class Tagsearch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTag;

	private String nameTag;
	private int numOfSearch;

	public Tagsearch() {
	}

	public int getIdTag() {
		return this.idTag;
	}

	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}

	public String getNameTag() {
		return this.nameTag;
	}

	public void setNameTag(String nameTag) {
		this.nameTag = nameTag;
	}

	public int getNumOfSearch() {
		return this.numOfSearch;
	}

	public void setNumOfSearch(int numOfSearch) {
		this.numOfSearch = numOfSearch;
	}

}