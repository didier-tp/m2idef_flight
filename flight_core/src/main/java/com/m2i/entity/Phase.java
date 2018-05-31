package com.m2i.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Embeddable
public class Phase implements Serializable{
	
	private static final long serialVersionUID = 1L;


	@Override
	public String toString() {
		return "Phase [localite=" + localite + ", dateTime=" + dateTime + "]";
	}
	
	@ManyToOne
	@JoinColumn(name="refLocalite")//sera redefini refLocDepart ou refLocArrivee
	private Localite localite;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dateTimePhase")//sera redefini dateTimeDepart ou dateTimeArrivee
	private Date dateTime;
	
	
	public Phase() {
		super();
	}
	public Phase(Localite localite, Date dateTime) {
		super();
		this.localite = localite;
		this.dateTime = dateTime;
	}
	
	public Localite getLocalite() {
		return localite;
	}
	
	public void setLocalite(Localite localite) {
		this.localite = localite;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
	

}
