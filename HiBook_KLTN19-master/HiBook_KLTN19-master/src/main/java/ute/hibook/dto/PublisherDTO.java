package ute.hibook.dto;

public class PublisherDTO {

	private String namePublisher;
	private int numBookSearch;
	public PublisherDTO(String namePublisher, int numBookSearch) {
		super();
		this.namePublisher = namePublisher;
		this.numBookSearch = numBookSearch;
	}
	public String getNamePublisher() {
		return namePublisher;
	}
	public void setNamePublisher(String namePublisher) {
		this.namePublisher = namePublisher;
	}
	public int getNumBookSearch() {
		return numBookSearch;
	}
	public void setNumBookSearch(int numBookSearch) {
		this.numBookSearch = numBookSearch;
	}
	
	
}
