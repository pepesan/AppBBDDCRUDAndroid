package com.cursosdedesarrollo.myapplication.beans;

import java.io.Serializable;

public class Valoration implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -383231886005873194L;
	private Float facepoints;
	private Float boobspoints;
	private Float buttpoints;
	private String note;

	public Valoration() {
		// TODO Auto-generated constructor stub
	}
	public Valoration(Float facepoints, Float boobspoints, Float buttpoints,
			String note) {
		super();
		this.facepoints = facepoints;
		this.boobspoints = boobspoints;
		this.buttpoints = buttpoints;
		this.note = note;
	}
	public Float getFacepoints() {
		return facepoints;
	}
	public void setFacepoints(Float facepoints) {
		this.facepoints = facepoints;
	}
	public Float getBoobspoints() {
		return boobspoints;
	}
	public void setBoobspoints(Float boobspoints) {
		this.boobspoints = boobspoints;
	}
	public Float getButtpoints() {
		return buttpoints;
	}
	public void setButtpoints(Float buttpoints) {
		this.buttpoints = buttpoints;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	

}
