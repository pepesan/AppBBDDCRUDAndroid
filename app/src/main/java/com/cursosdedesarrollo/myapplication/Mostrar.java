package com.cursosdedesarrollo.myapplication;

import java.util.List;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Mostrar extends AppActivity {

	private Long id;
	private boolean primera=true; 
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mostrar);
		Bundle extras = getIntent().getExtras();
        id = extras.getLong("id");
		tv=(TextView)findViewById(R.id.mostrar_tv);
		tv.setText(app.get(id).getName());
	}
	public void edit(View v){
		Intent intent=new Intent(this,
						AddEdit.class);
		intent.putExtra("id", id);
		this.startActivity(intent);
	}
	@Override
	public void onResume(){
		super.onResume();
		if(primera==true){
			primera=false;
		}else{
			tv.setText(app.get((long)id).getName());
		}
	}
	public void delete(View v){
		app.remove(app.get((long)id));
		Toast.makeText(this, R.string.deleted, Toast.LENGTH_SHORT).show();
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_mostrar, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
			case R.id.menu_edit:
				edit(null);
				return true;
			case R.id.menu_delete:
				delete(null);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}
