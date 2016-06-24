package com.cursosdedesarrollo.myapplication;




import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppListActivity {
	ListView lv;
	TestListAdapter adapter;
	private Boolean primera=true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=this.getListView();
		adapter=new TestListAdapter(this,
				R.layout.item,datos);
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
			adapter.forceReload();
		}
	}
	
}
