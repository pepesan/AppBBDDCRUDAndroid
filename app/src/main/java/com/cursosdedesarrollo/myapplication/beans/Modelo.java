package com.cursosdedesarrollo.myapplication.beans;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static com.cursosdedesarrollo.myapplication.beans.PersonSqliteHelper.PERSON_GLOBAL;
import static com.cursosdedesarrollo.myapplication.beans.PersonSqliteHelper.PERSON_ID;
import static com.cursosdedesarrollo.myapplication.beans.PersonSqliteHelper.PERSON_LATITUDE;
import static com.cursosdedesarrollo.myapplication.beans.PersonSqliteHelper.PERSON_LOCATION;
import static com.cursosdedesarrollo.myapplication.beans.PersonSqliteHelper.PERSON_LONGITUDE;
import static com.cursosdedesarrollo.myapplication.beans.PersonSqliteHelper.PERSON_NAME;
import static com.cursosdedesarrollo.myapplication.beans.PersonSqliteHelper.PERSON_PHOTOPATH;
import static com.cursosdedesarrollo.myapplication.beans.PersonSqliteHelper.PERSON_TABLE;
import static com.cursosdedesarrollo.myapplication.beans.PersonSqliteHelper.PERSON_THUMBPHOTOPATH;
import static com.cursosdedesarrollo.myapplication.beans.PersonSqliteHelper.PERSON_TLF;

/**
 * Created by pepesan on 20/3/18.
 */

public class Modelo {
    private SQLiteDatabase db;
    private List<Person> listado;
    Modelo(Aplicacion aplicacion){
        PersonSqliteHelper helper =
                new PersonSqliteHelper(aplicacion);
        db = helper.getWritableDatabase();
        listado=new ArrayList<Person>();
        this.loadList();
    }
    public List<Person> getPersons(){
        return listado;
    }
    private void loadList() {
        listado = new ArrayList<Person>();
        Cursor personCursor = db.query(PERSON_TABLE,
                new String[] {PERSON_ID,
                        PERSON_NAME,
                        PERSON_TLF,PERSON_GLOBAL,
                        PERSON_PHOTOPATH,
                        PERSON_THUMBPHOTOPATH,
                        PERSON_LOCATION},
                null, null, null, null,
                //String.format("%s,%s",PERSON_GLOBAL, PERSON_NAME )
                String.format("%s",
                        PERSON_GLOBAL));
        personCursor.moveToFirst();
        Person p;
        if (! personCursor.isAfterLast()) {
            do {
                Long id = personCursor.getLong(0);
                String name  = personCursor.getString(1);
                String tlf = personCursor.getString(2);
                Float global = personCursor.getFloat(3);
                String filename  = personCursor.getString(4);
                String thumbfilename = personCursor.getString(5);
                String location = personCursor.getString(6);
                p = new Person(id,name,tlf,global);
                p.setPhotopath(filename);
                p.setThumbphotopath(thumbfilename);
                p.setLocation(location);
                listado.add(p);
            } while (personCursor.moveToNext());
        }

        personCursor.close();

    }
    public void add(Person p){
        assert(null != p);

        ContentValues values = new ContentValues();
        values.put(PERSON_NAME, p.getName());
        values.put(PERSON_TLF, p.getTlf());
        values.put(PERSON_GLOBAL, p.getGlobalpoints());
        values.put(PERSON_PHOTOPATH, p.getPhotopath());
        values.put(PERSON_THUMBPHOTOPATH, p.getThumbphotopath());
        values.put(PERSON_LOCATION, p.getLocation());
        values.put(PERSON_LATITUDE, p.getLatitude());
        values.put(PERSON_LONGITUDE, p.getLongitude());

        p.setId(db.insert(PERSON_TABLE, null, values));

        listado.add(p);
    }
    @SuppressLint("DefaultLocale")
    public void set(Person p) {
        assert(null != p);
        ContentValues values = new ContentValues();
        values.put(PERSON_NAME, p.getName());
        values.put(PERSON_TLF, p.getTlf());
        values.put(PERSON_GLOBAL, p.getGlobalpoints());
        values.put(PERSON_PHOTOPATH, p.getPhotopath());
        values.put(PERSON_THUMBPHOTOPATH, p.getThumbphotopath());
        values.put(PERSON_LOCATION, p.getLocation());
        values.put(PERSON_LATITUDE, p.getLatitude());
        values.put(PERSON_LONGITUDE, p.getLongitude());
        long id = p.getId();
        Log.d("id", ""+id);
        String where = String.format("%s = %d",
                PERSON_ID, id);

        db.update(PERSON_TABLE, values, where, null);
        int tam=listado.size();
        for(int i=0;i<tam;i++){
            Person p2=listado.get(i);
            if(p.getId()==p2.getId()){
                listado.set(i,p);
                break;
            }
        }
    }
    public void remove(Person p) {
        String where = String.format("%s = %s",
                PERSON_ID,
                p.getId());
        db.delete(PERSON_TABLE, where, null);
        listado.remove(p);
    }

    public Person get(Long id){
        int count =listado.size();
        for(int i=0;i<count;i++){
            Person p= listado.get(i);
            if(p.getId()==id){
                return p;
            }
        }
        return new Person();
    }
    public void removePersonByName(String s){
        //TODO: quitar persona por nombre
        //listado.remove(s);
    }
}
