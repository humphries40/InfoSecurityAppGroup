package com.example.alarmit;

import java.io.IOException;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;



public class Alarm extends Activity {

	MediaPlayer mp;
	int volume_level;
	static final int REQUEST_IMAGE_CAPTURE = 1; //Part of the Camera taking Process
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm);
		mp = MediaPlayer.create(getApplicationContext(), R.raw.alarm);
		AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		volume_level = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alarm, menu);
		return true;
	}
	
	/** Called when the user clicks the start alarm button */
    public void start_alarm(View view) {
        // Do something in response to button
    	AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    	int max = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    	audio.setStreamVolume(AudioManager.STREAM_MUSIC, max, 0);
    	mp.start();
    }
    
    /** Called when the user clicks the stop alarm button 
     * @throws IOException 
     * @throws IllegalStateException */
    public void stop_alarm(View view) throws IllegalStateException, IOException {
        // Do something in response to button
    	AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    	audio.setStreamVolume(AudioManager.STREAM_MUSIC, volume_level, 0);
    	mp.stop();
    	mp.prepare();
    }
    
    /** Called when the user clicks the start alarm button */
    public void back(View view) {
        // Do something in response to button
    	Intent intent = new Intent(this, HomeScreen.class);
    	startActivity(intent);
    }
    
    
    //Takes a Picture with the Camera
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

}
