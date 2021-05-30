package br.com.digitalhouse.restaurantapi.dataprovider.repository.entity;

public class CashBoxData {

	private double totalInBox;

	public CashBoxData() {
	}
	
	public CashBoxData(double totalInBox) {
		this.totalInBox = totalInBox;
	}

	public double getTotalInBox() {
		return totalInBox;
	}

	public void setTotalInBox(double totalInBox) {
		this.totalInBox = totalInBox;
	}
	
}
