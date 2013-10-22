package com.eggs;
/**
 * This class represents a restaurant
 * @author Csaba_Valyi
 *
 */
public class Restaurant {

	private String name;
	private String url;
	private Address address;
	private Menu menu;
	
	public Restaurant() {
	}

	public Restaurant(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
