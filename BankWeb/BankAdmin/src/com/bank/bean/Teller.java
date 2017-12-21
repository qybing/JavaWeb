package com.bank.bean;

public class Teller {
	private int id;
	private String teller_id;
	private String teller_name;
	private String teller_ps;
	private String subbank_id;

	public Teller() {
		super();
	}

	public Teller(String teller_id, String teller_name, String teller_ps, String subbank_id) {
		super();
		this.teller_id = teller_id;
		this.teller_name = teller_name;
		this.teller_ps = teller_ps;
		this.subbank_id = subbank_id;
	}

	public String getTeller_id() {
		return teller_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTeller_id(String teller_id) {
		this.teller_id = teller_id;
	}

	public String getTeller_name() {
		return teller_name;
	}

	public void setTeller_name(String teller_name) {
		this.teller_name = teller_name;
	}

	public String getTeller_ps() {
		return teller_ps;
	}

	public void setTeller_ps(String teller_ps) {
		this.teller_ps = teller_ps;
	}

	public String getSubbank_id() {
		return subbank_id;
	}

	public void setSubbank_id(String subbank_id) {
		this.subbank_id = subbank_id;
	}

	@Override
	public String toString() {
		return "Teller [id=" + id + ", teller_id=" + teller_id + ", teller_name=" + teller_name + ", teller_ps="
				+ teller_ps + ", subbank_id=" + subbank_id + "]";
	}

}
