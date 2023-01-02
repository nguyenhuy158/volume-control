package com.nguyenhuy158.volumecontrol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity
		implements SeekBar.OnSeekBarChangeListener {
	private AppCompatSeekBar appCompatSeekBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bindUI();
		handleEvent();
	}
	
	private void handleEvent() {
		appCompatSeekBar.setOnSeekBarChangeListener(this);
	}
	
	private void bindUI() {
		 appCompatSeekBar = findViewById(R.id.seekBarVolume);
	}
	
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
	                              boolean fromUser) {
		// Log.d(STRING.TAG, "onProgressChanged: " + progress);
		
	}
	
	
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
	
	}
	
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
	
	}
}