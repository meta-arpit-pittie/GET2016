/**
 * Assignment 1
 * POJO class to simulate the titles table in the database
 * @author Arpit Pittie
 */
package session1;

public class Titles {

	private int titleId;	//The title id
	private String titleName;	//The title name
	private String subjectId;	//The subject id
	private String publisherId;	//The publisher id
	
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}
	
	public int getTitleId() {
		return titleId;
	}
	
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	public String getTitleName() {
		return titleName;
	}
	
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
	public String getSubjectId() {
		return subjectId;
	}
	
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	
	public String getPublisherId() {
		return publisherId;
	}
}
