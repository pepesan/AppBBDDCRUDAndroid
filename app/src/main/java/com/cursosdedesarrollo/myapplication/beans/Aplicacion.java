package com.cursosdedesarrollo.myapplication.beans;



import java.util.List;

import android.annotation.SuppressLint;
import android.app.Application;

@SuppressLint("DefaultLocale")
public class Aplicacion extends Application {
	private List<Person> listado;
	private Modelo modelo;
	@Override
	public void onCreate() {
		super.onCreate();
		modelo=new Modelo(this);
		listado=modelo.getPersons();
	}
	
	public List<Person> getPersons(){
		return modelo.getPersons();
	}
	public Person get (Long id){
		return  modelo.get(id);
	}
	public void remove (Person p){
		modelo.remove(p);
	}
	public void add(Person p){
		modelo.add(p);
	}
	public void set (Person p){
		modelo.set(p);
	}



}
