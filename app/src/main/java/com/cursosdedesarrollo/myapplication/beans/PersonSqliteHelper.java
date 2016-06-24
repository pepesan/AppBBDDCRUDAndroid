package com.cursosdedesarrollo.myapplication.beans;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class PersonSqliteHelper extends SQLiteOpenHelper {
	
	public static final int VERSION = 2;
	public static final String DB_NAME  = "person_db.sqlite";
	public static final String PERSON_TABLE  = "person";
	public static final String PERSON_ID = "person_id";
	public static final String PERSON_NAME = "name";
	public static final String PERSON_TLF  = "tlf";
	public static final String PERSON_GLOBAL  = "global";
	public static final String PERSON_PHOTOPATH = "photopath";
	public static final String PERSON_THUMBPHOTOPATH = "thumbphotopath";
	public static final String PERSON_LOCATION  = "location";
	public static final String PERSON_LONGITUDE  = "longitude";
	public static final String PERSON_LATITUDE  = "latitude";
	public static final String VALORATION_TABLE  = "valorations";
	public static final String VALORATION_ID  = "valoration_id";
	public static final String VALORATION_FACE  = "face";
	public static final String VALORATION_BOOBS  = "boobs";
	public static final String VALORATION_BUTT  = "butt";
	public static final String VALORATION_NOTE  = "note";

	public PersonSqliteHelper(Context context) {
		super(context, DB_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		dropAndCreate(db);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, 
			int oldVersion,
			int newVersion) {
		if(oldVersion==1 && newVersion==2){
			db.execSQL("alter table " + PERSON_TABLE 
					+ " add column " 
					+ PERSON_PHOTOPATH + " text");
			db.execSQL("alter table " + PERSON_TABLE + 
					" add column " + PERSON_THUMBPHOTOPATH 
					+ " text");
			db.execSQL("alter table " + PERSON_TABLE + " add column " 
					+ PERSON_LOCATION + " text");
			db.execSQL("alter table " + PERSON_TABLE + " add column " 
					+ PERSON_LATITUDE + " real");
			db.execSQL("alter table " + PERSON_TABLE + " add column " 
					+ PERSON_LONGITUDE + " real");
			Log.d("app", "database actualizada");
		}
	}
	protected void dropAndCreate(SQLiteDatabase db) {
		db.execSQL("drop table if exists " + PERSON_TABLE + ";");
		db.execSQL("drop table if exists " + VALORATION_TABLE + ";");
		createTables(db);
	}
	
	protected void createTables(SQLiteDatabase db) {
		db.execSQL(
				"create table " + PERSON_TABLE +" (" +
				PERSON_ID + " integer primary key autoincrement " +
						"not null," +
				PERSON_NAME + " text not null," +
				PERSON_TLF + " text," +
				PERSON_GLOBAL + " text," +
				PERSON_PHOTOPATH + " text, " +
				PERSON_THUMBPHOTOPATH + " text, " +
				PERSON_LOCATION + " text, " +
				PERSON_LATITUDE + " real, " +
				PERSON_LONGITUDE + " real " +
				");"
			);
		db.execSQL(
				"create table " + VALORATION_TABLE +" (" +
				VALORATION_ID + " integer primary key " +
						"autoincrement not null," +
				PERSON_ID + " integer," +
				VALORATION_FACE + " float," +
				VALORATION_BOOBS + " float," +
				VALORATION_BUTT + " float," +
				VALORATION_NOTE + " text " +
				PERSON_ID +" REFERENCES "+PERSON_TABLE+"("
				+PERSON_ID+") "
	        	+ "ON DELETE CASCADE);"
			);
	}

}
