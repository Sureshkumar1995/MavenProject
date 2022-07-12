package org.maven.pom;

import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass {

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
}
