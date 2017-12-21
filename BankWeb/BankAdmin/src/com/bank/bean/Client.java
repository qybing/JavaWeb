package com.bank.bean;

public class Client {
	private int id;
	private String client_id;
	private String client_name;
	private String client_phone;
	private Double client_money;
	private String client_ps;

	public Client() {
		super();
	}

	public Client(String client_id, String client_name, String client_phone, Double client_money, String client_ps) {
		super();
		this.client_id = client_id;
		this.client_name = client_name;
		this.client_phone = client_phone;
		this.client_money = client_money;
		this.client_ps = client_ps;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClient_ps() {
		return client_ps;
	}

	public void setClient_ps(String client_ps) {
		this.client_ps = client_ps;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getClient_phone() {
		return client_phone;
	}

	public void setClient_phone(String client_phone) {
		this.client_phone = client_phone;
	}

	public Double getClient_money() {
		return client_money;
	}

	public void setClient_money(Double client_money) {
		this.client_money = client_money;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", client_id=" + client_id + ", client_name=" + client_name + ", client_phone="
				+ client_phone + ", client_money=" + client_money + ", client_ps=" + client_ps + "]";
	}

}
