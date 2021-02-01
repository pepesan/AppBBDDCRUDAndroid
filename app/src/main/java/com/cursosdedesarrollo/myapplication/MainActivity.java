package com.cursosdedesarrollo.myapplication;




import android.os.Bundle;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cursosdedesarrollo.myapplication.beans.Aplicacion;
import com.cursosdedesarrollo.myapplication.beans.Modelo;
import com.cursosdedesarrollo.myapplication.beans.Person;

import java.util.List;

public class MainActivity extends AppCompatActivity {
	private ListView lv;
	private TextView empty;
	private TestListAdapter adapter;
	private Boolean primera=true;
	private Aplicacion app;
	private List<Person> datos;
	private Modelo modelo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=(ListView) findViewById(R.id.list);
		empty=(TextView)findViewById(R.id.empty);
		app=(Aplicacion) getApplication();
		modelo=app.getModelo();
		//esto podría colocarse en un ASyncTask
		modelo.loadList();

		datos=app.getPersons();
		adapter=new TestListAdapter(this,
				R.layout.item,datos);
		if(datos.size()<=0){
			empty.setVisibility(View.VISIBLE);
			lv.setVisibility(View.GONE);
		}
		lv.setAdapter(adapter);
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, 
		    		View view,
		        int position, long id) {
		    	Intent intent = new Intent(MainActivity.this, 
						Mostrar.class);
		    	intent.putExtra("id", id);
		    	startActivity(intent);	
		    	
		    }
		});
	}
	
	public void goAdd(View v){
		Intent intent=new Intent(this,AddEdit.class);
		this.startActivity(intent);
	}
	@Override
	public void onResume(){
		super.onResume();
		if(primera==true){
			primera=false;
		}else{
			if(datos.size()>0){
				empty.setVisibility(View.GONE);
				lv.setVisibility(View.VISIBLE);
			}else{
				empty.setVisibility(View.VISIBLE);
				lv.setVisibility(View.GONE);
			}
			adapter.forceReload();
		}
	}
	public Integer back=0;
	@Override
	public void onBackPressed() {
		if(back==0){
			back=1;
			Toast.makeText(this,"Pulsa dos veces volver para salir",
					Toast.LENGTH_LONG).show();
		}else{
			super.onBackPressed();
			//finish();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
			case R.id.menu_add:
				goAdd(null);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
}
