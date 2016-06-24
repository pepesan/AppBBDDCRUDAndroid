package com.cursosdedesarrollo.myapplication.beans;

import java.io.Serializable;
import java.util.List;

import android.location.Address;

public class Person implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7402097807653944314L;
	/**
	 * 
	 */
	private Long id;
	private String name;
	private String tlf;
	private Float globalpoints;
	private String photopath;
	private String thumbphotopath;
	private String location;
	private double latitude;
	private double longitude;
	
	private List<Valoration> valorations;
	
	public Person(){
		setId((long) 0);
		name="";
		tlf="";
		setGlobalpoints(0.0f);
	}

	
	public Person(Long id,String name, String tlf, Float globalpoints) {
		this.setId(id);
		this.name = name;
		this.tlf = tlf;
		this.globalpoints = globalpoints;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}


	public Float getGlobalpoints() {
		return globalpoints;
	}


	public void setGlobalpoints(Float globalpoints) {
		this.globalpoints = globalpoints;
	}


	public List<Valoration> getValorations() {
		return valorations;
	}


	public void setValorations(List<Valoration> valorations) {
		this.valorations = valorations;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String s){
		this.location=s;
	}
	public void setAddressLocation(Address a) {
		if (null == a) {
			location = null;
			latitude = longitude = 0;
		} else {
			int maxAddressLine = a.getMaxAddressLineIndex();
			StringBuffer sb = new StringBuffer("");
			for (int i=0; i<maxAddressLine; i++) {
				sb.append(a.getAddressLine(i) + " ");
			}
			location = sb.toString();
			latitude = a.getLatitude();
			longitude = a.getLongitude();
		}
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public String getPhotopath() {
		return photopath;
	}


	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}


	public String getThumbphotopath() {
		return thumbphotopath;
	}


	public void setThumbphotopath(String thumbphotopath) {
		this.thumbphotopath = thumbphotopath;
	}


	@Override
	public String toString() {
		return name;
	}

	
}
