package io.evently.metrobusapp;

import io.evently.Controller.ModelController;
import io.evently.Entity.Model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.event_apps.Helper.Memory;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	ModelController mc = new ModelController();
	ArrayList<Model> data = new ArrayList<Model>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		init();
	}
	
	public void init(){
		loadData();
		populateFromData(); // probably in the onFinish function later
	}
	
	public void loadData(){
		// delete this shit later
		Model m = new Model();
		m.setBusName("niggabus");
		m.setStopDate(new Date());
		data.add(m);
		m = new Model();
		m.setBusName("crackabus");
		m.setStopDate(new Date());
		data.add(m);
	}
	
	public void populateFromData(){
		LinearLayout ll_container = (LinearLayout)findViewById(R.id.ll_container);
		for (Model m : data) {
			ll_container.addView(
					listTimeLayoutElement(
							m));
		}
	}
	
	public RelativeLayout listTimeLayoutElement(Model m){
		RelativeLayout listElement = (RelativeLayout) LayoutInflater.from(getApplicationContext()).inflate(R.layout.element_list_time, null);
		
		TextView tv_bus_name = (TextView)listElement.findViewById(R.id.tv_bus_name);
		TextView tv_stop_time = (TextView)listElement.findViewById(R.id.tv_stop_time);
		
		tv_bus_name.setText(m.getBusName());
		tv_stop_time.setText(mc.dateToString(m.getStopDate()));
		
		return listElement;
	}
	
	public class AsyncJsonPull extends AsyncTask<String, Void, String> {
		Context context;
		
		public AsyncJsonPull(Context context){
			super();
			this.context = context;
		}
		
	    @Override
	    protected String doInBackground(String... urls) {
	      String response = "";
	      for (String url : urls) {
	        DefaultHttpClient client = new DefaultHttpClient();
	        HttpGet httpGet = new HttpGet(url);
	        try {
	          HttpResponse execute = client.execute(httpGet);
	          InputStream content = execute.getEntity().getContent();

	          BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
	          String s = "";
	          while ((s = buffer.readLine()) != null) {
	            response += s;
	          }

	        } catch (Exception e) {
	          e.printStackTrace();
	        }
	      }
	      return response;
	    }

	    @Override
	    protected void onPostExecute(String result) {
	    	new Memory(context).setJson(result);
	    	
	    }
	    
	    
	}
	

}
