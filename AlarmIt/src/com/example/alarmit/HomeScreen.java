package com.example.alarmit;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class HomeScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }
    
    /** Called when the user clicks the alarm button */
    public void goto_alarm(View view) {
        // Do something in response to button
    	Intent intent = new Intent(this, Alarm.class);
    	startActivity(intent);
    }
    
    /** Called when the user clicks the alarm button */
    public void call(View view) {
        // Do something in response to button
    	Intent callIntent = new Intent(Intent.ACTION_CALL);
    	//This is my phone number insteed of 911 right now
    	callIntent.setData(Uri.parse("tel:4402314781"));
    	startActivity(callIntent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }
    
}
