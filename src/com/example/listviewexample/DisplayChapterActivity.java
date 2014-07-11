package com.example.listviewexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.example.listviewexample.MainActivity;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class DisplayChapterActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_display_chapter);
	    // Create the text view
	    TextView textView = (TextView) this.findViewById(R.id.textView1);
	    textView.setMovementMethod(new ScrollingMovementMethod());
	    
	    Intent i = getIntent();
	    String message = i.getExtras().getString(MainActivity.EXTRA_MESSAGE);
//	    Log.d("INFO","message "+message);
	    //some how mappy message to ke1 file
	    
	    Resources res = getResources();	    
	    int id = Integer.parseInt(message);
		id++;		
		message = Integer.toString(id);
		
	    String fileName = "ke"+message;
	    int fileId = res.getIdentifier(fileName, "raw", getPackageName());
//	    playSound(mediaPlayer, soundId);
	    
	    InputStream is = this.getResources().openRawResource(fileId);
	    BufferedReader br = new BufferedReader(new InputStreamReader(is));	    
	    String str = null;
	    String messageTxt = "";
	    try {
	    	while ((str = br.readLine()) != null) {
	    		messageTxt += str;
	    	}
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    
	    textView.setText(messageTxt);
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_chapter, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_display_chapter,
					container, false);
			return rootView;
		}
	}

}
