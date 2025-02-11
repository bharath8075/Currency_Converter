package com.example.currency_converter.dto;

public class ResponseDto {
	
	private String from;
	private String to;
	private int amount;
	private double convertedAmount;
	
	public ResponseDto(String from, String to, int amount, double convertedAmount) {
		super();
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.convertedAmount = convertedAmount;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
	

	
}
