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
@Table(name = "table_phone")
public class Phone implements Serializable {
	private static final long serialVersionUID = 3L;
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column
	private long phoneNo;
	@Column
	private Date date;

	public Phone() {
		super();
	}

	public Phone(long phoneNo, Date date) {
		super();
		this.phoneNo = phoneNo;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getPhone() {
		return phoneNo;
	}

	public void setPhone(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", phoneNo=" + phoneNo + ", date=" + date + "]";
	}

}
