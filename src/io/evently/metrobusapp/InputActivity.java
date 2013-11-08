package io.evently.metrobusapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class InputActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input);
	}
	
	public void onSubmitClick(View v){
		TextView tv = null;
		String stopId = (String) tv.getText();
		
		Intent i = new Intent();
		i.putExtra("stopId", stopId);
		startActivity(i);
	}
	
	

}
