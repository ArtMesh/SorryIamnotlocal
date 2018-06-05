package com.artmesh.sorryiamnotlocal;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity implements MainChoiceFragment.choiceClickListener {

	@Override
	public void buttonClick(int buttonId) {
		switch (buttonId){
			case R.id.buttonChoice:
				// переходим на ноую активити City
				Intent newActivity = new Intent(this, CityActivity.class);
				//downloadIntent.setData(Uri.parse(fileUrl));
				startActivity(newActivity);
				break;
			case R.id.buttonMap:
				// взять другой фрагмент
				MainMapFragment mapFragment = new MainMapFragment();
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

				transaction.replace(R.id.main_fragment_container, mapFragment);
				transaction.addToBackStack(null);
				transaction.commit();
				break;
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//		setActionBar(toolbar);

		if (findViewById(R.id.main_fragment_container) != null){
			if (savedInstanceState != null){
				return;
			}
		}

		MainChoiceFragment choiceFragment = new MainChoiceFragment();
		choiceFragment.setArguments(getIntent().getExtras());

		getSupportFragmentManager().beginTransaction().add(
				R.id.main_fragment_container, choiceFragment
		).commit();


	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			default:
				return super.onOptionsItemSelected(item);
		}
	}

}