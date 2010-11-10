package android.pizzabutton;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.*;
import android.pizzabutton.HttpHelper;

public class orderpizza extends Activity {
	// TODO: Make this accessible to all classes in the app.
	private static final String TAG = "PizzaButton";

	  public void ToastMsg(String message) {
		    Toast msg = Toast.makeText(
		        getApplicationContext(),
		        message,
		        Toast.LENGTH_LONG);

		    msg.show();
	}

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadPage(R.layout.main);
        // do shit to the page
        // get a list of pizzas and display them
        // how can do this?
        //getPizzaTypes();
        bindButtonToListener(R.id.pizza, pizzaButtonListener);
    }

    private OnClickListener pizzaButtonListener = new OnClickListener() {
    	public void onClick(View v) {
    		loadPage(R.layout.info);
    	}
    };

    private void loadPageInfo() {
        String result = HttpHelper.doHttpGet("http://thepizzabutton.appspot.com/pizza", null);

        try {
        	// NOTE: JSONArray vs JSONObject for [] or {}, respectively.
	        JSONArray json = new JSONArray(result);

	        // TODO: Parse the json into a list of objects.

	        Log.v(TAG, json.toString());
        } catch (JSONException e) {
        	Log.v(TAG, "Error parsing JSON: "+e);
        }
    }
    
    ///////
    private void loadPage(int id) {
    	setContentView(id);
    }
    
    private void setTextById(int id, String text) {
        TextView textObj = (TextView)findViewById(id);
        textObj.setText(text);
    }
      
    private String getTextById(int id) {
    	TextView textObj = (TextView)findViewById(id);
        return textObj.getText().toString();
    }
    
    private void bindButtonToListener(int id, OnClickListener listener) {
        Button button = (Button)findViewById(id);
        button.setOnClickListener(listener);
    }  
}