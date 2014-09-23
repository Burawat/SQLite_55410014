package app.buusk15.sqlite_014;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class showDataActivity extends Activity{

@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	
	super.onCreate(savedInstanceState);
	


	   setContentView(R.layout.show);
		   
	   control014DB control014db = new control014DB(this);
	   ArrayList<HashMap<String, String>> arrayList = control014db.SelectAllData();
	   
	   ListView ls= (ListView) findViewById(R.id.listView1);
	   
	   SimpleAdapter adapter;
	   adapter = new SimpleAdapter(showDataActivity.this, arrayList,
			   R.layout.show_item,new String[]{"MemberID", "Name", "Tel"},
			   new int[]{R.id.Member,R.id.Name,R.id.Tel});
	   ls.setAdapter(adapter);
	
	
	


}
}