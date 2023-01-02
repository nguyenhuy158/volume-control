package com.nguyenhuy158.volumecontrol;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
	private AppCompatSeekBar appCompatSeekBar;
	private AudioManager     audioManager;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bindUI();
		setDefaultValue();
		handleEvent();
	}
	
	private void setDefaultValue() {
		// set max volume
		int max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		appCompatSeekBar.setMax(max);
		
		// set current volume into seekbar
		int current = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
		appCompatSeekBar.setProgress(current);
	}
	
	private void handleEvent() {
		appCompatSeekBar.setOnSeekBarChangeListener(this);
	}
	
	private void bindUI() {
		// ui
		appCompatSeekBar = findViewById(R.id.seekBarVolume);
		
		// other
		audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
			case KeyEvent.KEYCODE_VOLUME_DOWN:
			case KeyEvent.KEYCODE_VOLUME_UP:
				setDefaultValue();
				break;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		// Log.d(STRING.TAG, "onProgressChanged: progress = " + progress);
		audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, AudioManager.FLAG_SHOW_UI);
		// Log.d(STRING.TAG, "onProgressChanged: max = " + audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
	}
	
	
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
	
	}
	
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
	
	}
}