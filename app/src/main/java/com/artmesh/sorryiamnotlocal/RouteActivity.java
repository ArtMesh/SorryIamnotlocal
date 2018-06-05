package com.artmesh.sorryiamnotlocal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class RouteActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_city);

//		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//		setActionBar(toolbar);

		if (findViewById(R.id.route_fragment_container) != null){
			if (savedInstanceState != null){
				return;
			}
		}

		CityMapFragment mapFragment = new CityMapFragment();
		mapFragment.setArguments(getIntent().getExtras());

		getSupportFragmentManager().beginTransaction()
				.add(R.id.city_fragment_container, mapFragment).commit();


	}
}
