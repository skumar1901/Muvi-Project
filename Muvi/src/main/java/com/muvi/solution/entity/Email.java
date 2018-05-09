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
@Table(name = "table_email")
public class Email implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private String mail;
	@Column
	private Date date;

	
	public Email() {
		super();
	}

	public Email(String mail, Date date) {
		super();
		this.mail = mail;
		this.date = date;
		}

	public int getId() {
		return id;
	}


	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Email [id=" + id + ", mail=" + mail + ", date=" + date + "]";
	}

}
