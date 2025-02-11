package com.example.currency_converter.dto;

public class RequestDto {

	private String from;
	private String to;
	private int amount;
	
	
	
	public RequestDto() {
		super();
	}
	public RequestDto(String from, String to, int amount) {
		super();
		this.from = from;
		this.to = to;
		this.amount = amount;
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
	
	
}
