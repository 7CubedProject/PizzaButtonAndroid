package android.pizzabutton;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class orderpizza extends Activity {
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
        setContentView(R.layout.main);
        
        Button button = (Button)findViewById(R.id.pizza);
        button.setOnClickListener((android.view.View.OnClickListener) pizzaButtonListener);
    }
    
    private OnClickListener pizzaButtonListener = new OnClickListener() {
    	public void onClick(View v) {
    		setContentView(R.layout.info);
    	}
    };
    
    private void loadPageInfo() {
    	
    }
}