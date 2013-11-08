package io.evently.Controller;
// ^ this might cause issues as well ...
// is 100% fine to temporarily delete

import io.evently.Entity.Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

// temporarily commented to keep code running on Will's computer
// (ADT dependent imports)
/*
import android.content.Context;
*/

public class ModelController {
	
	// constants that may change later ...
	String URLTEMPLATE = "http://www.capmetro.org/info/?id=PLACEHOLDER";
	String STOPIDPLACEHOLDER = "PLACEHOLDER";
	
	String html;
	ArrayList<Model> data = new ArrayList<Model>();
	
	// Context context;
	
	public ModelController(/* Context context */) {
		// this.context = context;
	}
	
	public void addModel(Model model){
		this.data.add(model);
	}
	
	public String getURLForStopId(int stopId){
		return
			URLTEMPLATE.replace(
					STOPIDPLACEHOLDER,
					Integer.toString(stopId));
	}
	
	/*
	 * keep in this class to save readability in main thread
	 * -- not too relevant to this class's contents
	 */
	public String dateToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm", Locale.US);
		return sdf.format(date);
	}
	
	// TODO find a way to test this function with preset html
	/* i.e. don't bother taking time to code a class that will 
	 * retrieve data from the internet, as this will be done
	 * in an external Android class I will code
	 * 
	 * The code in that class will look something like:
	 * 
	 * int input = Android.MyActivity.grabUserInput();
	 * ModuleController mc = new ModuleController();
	 * String url = mc.getURLForStopId(input);
	 * String html = Android.MyActivity.getHtml(url); <--- what I will code
	 * mc.htmlToDataForStop(html);
	 */
	public void htmlToData(String html){
		Model model = new Model();
		
		// TODO read html here ...
		
		// placeholders (you will populate these strings)
		String busName = null;
		Date stopDate = null;
		
		model.setBusName(busName);
		model.setStopDate(stopDate);
		this.addModel(model);
	}
	
	public void orderDataByDate(){
		// TODO order data variable from earliest to latest
	}
	
	public void orderDataByBus(){
		// TODO order data variable from earliest to latest per bus
	}

}
