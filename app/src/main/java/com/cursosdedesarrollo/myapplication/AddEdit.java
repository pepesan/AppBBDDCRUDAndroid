package com.cursosdedesarrollo.myapplication;


import com.cursosdedesarrollo.myapplication.beans.Person;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddEdit extends AppActivity {

	private EditText editcadena;
	private Long id;
	private Person p;
	private boolean edit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_edit);
		try{
			Bundle extras = getIntent().getExtras();
	        id = extras.getLong("id");
	        p=app.get(id);
	        edit=true;
		}catch(Exception e){
			edit=false;
		}
		setUpviews();
	}

	private void setUpviews() {
		editcadena=(EditText)findViewById(R.id.cadena);
		if(edit==true){
			editcadena.setText(p.getName());
		}
	}
	@Override
	public void onBackPressed(){
		this.save(new View(this));
	}
	public void save(View v){
		String s=editcadena.getText().toString();
		Person p=new Person();
		p.setName(s);
		if(edit==false){
			app.add(p);
			Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT)
			.show();
		}else{
			p.setId(id);
			app.set(p);
			Toast.makeText(this, R.string.modified, Toast.LENGTH_SHORT)
			.show();
		}
			
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_add_edit, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
			case R.id.menu_save:
				save(null);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}
