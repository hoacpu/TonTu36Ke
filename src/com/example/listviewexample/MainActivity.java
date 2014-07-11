package com.example.listviewexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.example.listviewexample.DisplayChapterActivity;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	// The data to show
	public List<Map<String, String>> chaptersList = new ArrayList<Map<String,String>>();
	public final static String EXTRA_MESSAGE = "com.example.listviewexample.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
	    initList();
	    // We get the ListView component from the layout
	    ListView lv = (ListView) findViewById(R.id.listView);
	    // This is a simple adapter that accepts as parameter
	    // Context
	    // Data list
	    // The row layout that is used during the row creation
	    // The keys used to retrieve the data
	    // The View id used to show the data. The key number and the view id must match
//	    SimpleAdapter simpleAdpt = new ArrayAdapter(this, chaptersList, android.R.layout.simple_list_item_1, new String[] {"chapter"}, new int[] {android.R.id.text1});
	    String[] dataSource = getData();
	    
//	    String[] dataSource = {"test1","test2"};
	    
	    ListAdapter theAdapter = new MyArrayAdapter(this, dataSource);	    
	    lv.setAdapter(theAdapter);
	    
	 // React to user clicks on item
	    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	         public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
	                                 long id) {

	     		Intent intent = new Intent(MainActivity.this, DisplayChapterActivity.class);
	     		String message = Integer.toString(position);
	    		intent.putExtra(EXTRA_MESSAGE, message);
	    		
	    		// startActivity causes the Activity to start
	    		startActivity(intent);
	    		
	         }
	    });
	}
	
	private void initList() {
	    // We populate the planets

	    chaptersList.add(createTitle("chapter", "1. Dương đông kích tây"));
	    chaptersList.add(createTitle("chapter", "2. Điệu hổ ly sơn"));
	    chaptersList.add(createTitle("chapter", "3. Nhất tiễn hạ song điêu "));
	    chaptersList.add(createTitle("chapter", "4. Minh tri cố muội"));
	    chaptersList.add(createTitle("chapter", "5. Du long chuyển phượng "));
	    chaptersList.add(createTitle("chapter", "6. Mỹ nhân kế"));
	    chaptersList.add(createTitle("chapter", "7. Sấn hỏa đả kiếp"));
	    
	    chaptersList.add(createTitle("chapter", "8. Vô trung sinh hữu"));
	    chaptersList.add(createTitle("chapter", "9. Tiên phát chế nhân"));
	    chaptersList.add(createTitle("chapter", "10. Đả thảo kinh xà"));
	    chaptersList.add(createTitle("chapter", "11. Tá đao sát nhân"));
	    chaptersList.add(createTitle("chapter", "12. Di thể giá họa"));
	    chaptersList.add(createTitle("chapter", "13. Khích tướng kế "));
	    chaptersList.add(createTitle("chapter", "14. Man thiên quá hải "));
	    
	    chaptersList.add(createTitle("chapter", "15. Ám độ trần sương"));
	    chaptersList.add(createTitle("chapter", "16. Phản khách vi chủ"));
	    chaptersList.add(createTitle("chapter", "17. Kim thiền thoát xác"));
	    chaptersList.add(createTitle("chapter", "18. Không thành kế"));
	    chaptersList.add(createTitle("chapter", "19. Cầm tặc cầm vương"));
	    chaptersList.add(createTitle("chapter", "20. Ban chư ngật hổ"));
	    chaptersList.add(createTitle("chapter", "21. Quá kiều trừu bản"));
	    
	    chaptersList.add(createTitle("chapter", "22. Liên hoàn kế"));
	    chaptersList.add(createTitle("chapter", "23. Dĩ dật đãi lao"));
	    chaptersList.add(createTitle("chapter", "24. Chỉ tang mạ hòe"));
	    chaptersList.add(createTitle("chapter", "25. Lạc tỉnh hạ thạch"));
	    chaptersList.add(createTitle("chapter", "26. Hư trương thanh thế"));
	    chaptersList.add(createTitle("chapter", "27. Phủ để trừu tân"));
	    chaptersList.add(createTitle("chapter", "28. Sát kê hách hầu"));
	    
	    chaptersList.add(createTitle("chapter", "29. Phản gián kế"));
	    chaptersList.add(createTitle("chapter", "30. Lý đại đào cương"));
	    chaptersList.add(createTitle("chapter", "31. Thuận thủ khiên dương"));
	    chaptersList.add(createTitle("chapter", "32. Dục cầm cố tung"));
	    chaptersList.add(createTitle("chapter", "33. Khổ nhục kế"));
	    chaptersList.add(createTitle("chapter", "34. Phao bác dẫn ngọc "));
	    chaptersList.add(createTitle("chapter", "35. Tá thi hoàn hồn"));
	    chaptersList.add(createTitle("chapter", "36. Tẩu kế"));
	    

	}
	
	private String[] getData ()
	{
		Iterator<Map<String,String>> iter = chaptersList.iterator();
		String[] info = new String[36];
		int i =0;
		while (iter.hasNext()){
			Map<String,String> datas = iter.next();
			info[i++] = datas.get("chapter");
//			Log.d("INFO",datas.get("chapter"));
			
		}
		return info;
	}
	
	private HashMap<String, String> createTitle(String key, String name) {
    HashMap<String, String> title = new HashMap<String, String>();
	    title.put(key, name);

	    return title;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
