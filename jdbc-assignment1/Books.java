/**
 * Assignment 1
 * POJO class to simulate the books table in the database
 * @author Arpit Pittie
 */
package session1;

public class Books {

	private int accessionNumber;	//The accession number
	private int titleId;	//The title id
	private String purchaseDate;	//The purchase date
	private float price;	//The book price
	private String status;	//The book status
	
	public void setAccessionNumber(int accessionNumber) {
		this.accessionNumber = accessionNumber;
	}
	
	public int getAccessionNumber() {
		return accessionNumber;
	}
	
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}
	
	public int getTitleId() {
		return titleId;
	}
	
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public String getPurchaseDate() {
		return purchaseDate;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
