package org.maven.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BaseClass{
	
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	
	}

	@FindBy(id="location")
	private WebElement slctLocation;
	
	@FindBy(id="hotels")
	private WebElement slctHotels;
	
	@FindBy(id="room_type")
	private WebElement slctRoomType;

	@FindBy(id="room_nos")
	private WebElement slctRoomNo;
	
	@FindBy(id="adult_room")
	private WebElement slctAdultRoom;
	
	@FindBy(id="child_room")
	private WebElement slctChildRoom;
	
	@FindBy(id="Submit")
	private WebElement clkSearch;
	
	@FindBy(id="datepick_in")
	private WebElement checkIn;

	@FindBy (id="datepick_out")
	private WebElement checkOut;
	
	
	public WebElement getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(WebElement checkIn) {
		this.checkIn = checkIn;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(WebElement checkOut) {
		this.checkOut = checkOut;
	}

	public WebElement getSlctLocation() {
		return slctLocation;
	}

	public void setSlctLocation(WebElement slctLocation) {
		this.slctLocation = slctLocation;
	}

	public WebElement getSlctHotels() {
		return slctHotels;
	}

	public void setSlctHotels(WebElement slctHotels) {
		this.slctHotels = slctHotels;
	}

	public WebElement getSlctRoomType() {
		return slctRoomType;
	}

	public void setSlctRoomType(WebElement slctRoomType) {
		this.slctRoomType = slctRoomType;
	}

	public WebElement getSlctRoomNo() {
		return slctRoomNo;
	}

	public void setSlctRoomNo(WebElement slctRoomNo) {
		this.slctRoomNo = slctRoomNo;
	}

	public WebElement getSlctAdultRoom() {
		return slctAdultRoom;
	}

	public void setSlctAdultRoom(WebElement slctAdultRoom) {
		this.slctAdultRoom = slctAdultRoom;
	}

	public WebElement getSlctChildRoom() {
		return slctChildRoom;
	}

	public void setSlctChildRoom(WebElement slctChildRoom) {
		this.slctChildRoom = slctChildRoom;
	}

	public WebElement getClkSearch() {
		return clkSearch;
	}

	public void setClkSearch(WebElement clkSearch) {
		this.clkSearch = clkSearch;
	}
	
	private void searchHotels(String location,String hotels,String roomType,String roomNo,String checkIn,String checkOut,String adultRoom,String childRoom) {
		selectByValue(getSlctLocation(), location);
		selectByValue(getSlctHotels(), hotels);
		selectByValue(getSlctRoomType(), roomType);
		selectByValue(getSlctRoomNo(), roomNo);
		selectByValue(getSlctAdultRoom(), adultRoom);
		selectByValue(getSlctChildRoom(), childRoom);
		type(getCheckIn(), checkIn);
		type(getCheckOut(), checkOut);
		click(getClkSearch());
	}














}
