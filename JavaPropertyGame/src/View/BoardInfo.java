package View;

import java.awt.Color;

public class BoardInfo {

	String SquareName, SquareType;
	int price, mortgage, location;
	Color properyColor;
	
	public BoardInfo(String squareName, String squareType, int price, int mortgage, Color properyColor, int location) {
		super();
		SquareName = squareName;
		SquareType = squareType;
		this.price = price;
		this.mortgage = mortgage;
		this.properyColor = properyColor;
		this.location = location;
	}
	
	public String getSquareName() {
		return SquareName;
	}
	public void setSquareName(String squareName) {
		SquareName = squareName;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public String getSquareType() {
		return SquareType;
	}
	public void setSquareType(String squareType) {
		SquareType = squareType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMortgage() {
		return mortgage;
	}
	public void setMortgage(int mortgage) {
		this.mortgage = mortgage;
	}
	public Color getProperyColor() {
		return properyColor;
	}
	public void setProperyColor(Color properyColor) {
		this.properyColor = properyColor;
	}



}
