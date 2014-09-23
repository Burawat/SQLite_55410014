package app.buusk15.sqlite_014;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
SQLiteDatabase db;
private Button btninsert,btnshow;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control014DB control014db = new control014DB(this);
        control014db.getWritableDatabase();
        
        btninsert = (Button) findViewById(R.id.btninsert);
        btnshow   = (Button) findViewById(R.id.btn_show);
        btninsert.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View v){
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),AddActivity.class);
				startActivity(intent);
			}
        });
        
        btnshow.setOnClickListener(new OnClickListener(){
    	@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent showdata = new Intent(getApplicationContext(), showDataActivity.class);
			startActivity(showdata);
		}
	});
        }
}

    

 

