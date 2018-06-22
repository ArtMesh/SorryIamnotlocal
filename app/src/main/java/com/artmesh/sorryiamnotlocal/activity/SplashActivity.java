package com.artmesh.sorryiamnotlocal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		//setTheme(R.style.AppTheme);
		super.onCreate(savedInstanceState);
		goToEarth();
	}

	private void goToEarth(){
		Intent newActivity = new Intent(this, EarthActivity.class);
		startActivity(newActivity);
	}

}
