package com.muvi.solution.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table_passport")
public class Passport implements Serializable {
	private static final long serialVersionUID = 2L;
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column
	private String passportNo;
	@Column
	private Date date;

	public Passport() {
		super();
	}

	public Passport(String passportNo, Date date) {
		super();
		this.passportNo = passportNo;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", passportNo=" + passportNo + ", date=" + date + "]";
	}

}
