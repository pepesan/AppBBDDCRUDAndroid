package com.cursosdedesarrollo.myapplication;
import java.util.ArrayList;
import java.util.List;

import com.cursosdedesarrollo.myapplication.beans.Person;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TestListAdapter extends BaseAdapter {
	
	private List<Person> listado;
	private Context context;
	private int vista;

	public TestListAdapter(Context context, 
						int vista,
						List<Person> datos) {
		this.listado=datos;
		this.vista=vista;
		this.context = context;
	}

	public int getCount() {
		return listado.size();
	}

	public Person getItem(int position) {
		if(null == listado){
			return null;
		}else{
			return listado.get(position);
		}
	}

	public long getItemId(int position) {
		return this.getItem(position).getId();
	}

	public View getView(int position, View convertView, 
			ViewGroup parent) {
		//Log.d("getview",""+position);
		TextView tli;
		if (null == convertView) {
			tli = (TextView)View.inflate(context, 
					vista, null);
		} else {
			tli = (TextView)convertView;
		}
		tli.setText(listado.get(position).toString());
		Log.d("Presentando", ""+position);		
		return tli;
	}

	public void forceReload() {
		notifyDataSetChanged();
	}

	

}
