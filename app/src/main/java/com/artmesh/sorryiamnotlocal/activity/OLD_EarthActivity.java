//package com.artmesh.sorryiamnotlocal.activity;
//
//import android.Manifest;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.content.ContextCompat;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//
//import com.artmesh.sorryiamnotlocal.R;
//import com.artmesh.sorryiamnotlocal.database.DataBase;
//import com.artmesh.sorryiamnotlocal.database.SorryApp;
//import com.artmesh.sorryiamnotlocal.database.dao.CityDao;
//import com.artmesh.sorryiamnotlocal.database.dao.SpaceDao;
//import com.artmesh.sorryiamnotlocal.database.entities.Border;
//import com.artmesh.sorryiamnotlocal.database.entities.City;
//import com.artmesh.sorryiamnotlocal.database.entities.Coordinate;
//import com.artmesh.sorryiamnotlocal.database.entities.Space;
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.common.api.PendingResult;
//import com.google.android.gms.common.api.ResultCallback;
//import com.google.android.gms.common.api.Status;
//import com.google.android.gms.location.places.AutocompleteFilter;
//import com.google.android.gms.location.places.AutocompletePrediction;
//import com.google.android.gms.location.places.AutocompletePredictionBuffer;
//import com.google.android.gms.location.places.Place;
//import com.google.android.gms.location.places.PlaceBuffer;
//import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
//import com.google.android.gms.location.places.Places;
//import com.google.android.gms.location.places.ui.PlaceAutocomplete;
//import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
//import com.google.android.gms.location.places.ui.PlaceSelectionListener;
//import com.google.android.gms.maps.model.LatLngBounds;
//
//import java.util.List;
//
//import static android.content.ContentValues.TAG;
//
////MainChoiceFragment.choiceClickListener
//public class OLD_EarthActivity extends FragmentActivity implements  GoogleApiClient.OnConnectionFailedListener {
//
//	int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;
//
//	private static final String[] LOCATION_PERMISSIONS = new String[]{
//			Manifest.permission.ACCESS_FINE_LOCATION,
//	};
//
//	private static final int REQUEST_LOCATION_PERMISSIONS = 0;
//	PendingResult<PlaceLikelihoodBuffer> result;
//
//	private GoogleApiClient mGoogleApiClient;
//	private List<String> mListSpaceId;
//	private List<Space> mSpaces;
//
//	private DataBase mDataBase;
//	private SorryApp mApp;
//
//	private String mCityName;
//	private String mCityIdentifier;
//	private Coordinate mCityCoordinates;
//	private Border mCityBorders;
//
//	private LatLngBounds mLatLngBounds;
//
//	private City mCity;
//
//	private Button selectButton;
//
//	public void buttonClick(long cityId) {
//		Intent newActivity = new Intent(this, CityActivity.class);
//
//		Log.i("testArt","buttonClick EarthActivity cityId =  " + cityId);
//
//		newActivity.putExtra("city", cityId);
//		startActivity(newActivity);
//	}
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		setTheme(R.style.AppTheme);
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//
//		mApp = (SorryApp) getApplicationContext();
//		mDataBase = mApp.getDataBase();
//
//		selectButton = (Button) findViewById(R.id.buttonChoice);
//		selectButton.setOnClickListener(selectCity);
//
////		if (findViewById(R.id.main_fragment_container) != null) {
////			if (savedInstanceState != null) {
////				return;
////			}
////		}
//
////		MainChoiceFragment choiceFragment = new MainChoiceFragment();
////		choiceFragment.setArguments(getIntent().getExtras());
////
////		getSupportFragmentManager().beginTransaction().add(
////				R.id.main_fragment_container, choiceFragment
////		).commit();
//
//		//getPlaceButton = (Button) findViewById(R.id.get_place_button);
////		getPlaceButton.setOnClickListener(getPlaceClick);
//
//		mGoogleApiClient = new GoogleApiClient
//				.Builder(this)
//				.addApi(Places.GEO_DATA_API)
//				.addApi(Places.PLACE_DETECTION_API)
//				.enableAutoManage(this, this)
//				.build();
//
//		PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
//
//		AutocompleteFilter typeFilterCity = new AutocompleteFilter.Builder()
//				.setTypeFilter(AutocompleteFilter.TYPE_FILTER_CITIES)
//				.build();
//
//		autocompleteFragment.setFilter(typeFilterCity);
//
//		autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
//			@Override
//			public void onPlaceSelected(Place place) {
//				getCityAttribute(place);
//
//				Log.i(TAG, "onPlaceSelected RUN - Place: " + place.getName());
//			}
//
//			@Override
//			public void onError(Status status) {
//				Log.i(TAG, "An error occurred: " + status);
//			}
//		});
//
//	}
//
//	@Override
//	public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//
//	}
//
//	@Override
//	public void onRequestPermissionsResult(int requestCode, String[] permissions,
//										   int[] grantResults) {
//		switch (requestCode) {
//			case REQUEST_LOCATION_PERMISSIONS:
//				if (hasLocationPermission()) {
//
//				}
//			default:
//				super.onRequestPermissionsResult(requestCode, permissions,
//						grantResults);
//		}
//	}
//
//	private boolean hasLocationPermission() {
//		int result = ContextCompat.checkSelfPermission(this, LOCATION_PERMISSIONS[0]);
//		return result == PackageManager.PERMISSION_GRANTED;
//	}
//
////	private View.OnClickListener getPlaceClick = new View.OnClickListener() {
////		@Override
////		public void onClick(View view) {
////
////			if (hasLocationPermission()) {
////				if (ActivityCompat.checkSelfPermission(view.getContext()
////						,Manifest.permission.ACCESS_FINE_LOCATION)
////						!= PackageManager.PERMISSION_GRANTED) {
////					return;
////				}
////				ArrayList<String> filterArray = new ArrayList<>();
////				filterArray.add("TYPE_LOCALITY");
////
////				PlaceFilter filter = new PlaceFilter(false, filterArray);
////				result = Places.PlaceDetectionApi.getCurrentPlace(mGoogleApiClient, filter);
////
////
////				result.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {
////					@Override
////					public void onResult(PlaceLikelihoodBuffer likelyPlaces) {
////						for (PlaceLikelihood placeLikelihood : likelyPlaces) {
////							Log.i("PlaceDetection", String.format("Place '%s' has likelihood: %g",
////									placeLikelihood.getPlace().getName(),
////									placeLikelihood.getLikelihood()));
////						}
////						likelyPlaces.release();
////					}
////				});
////
////			} else {
////				requestPermissions(LOCATION_PERMISSIONS,
////						REQUEST_LOCATION_PERMISSIONS);
////			}
////		}
////	};
//
//	@Override
//	public void onActivityResult(int requestCode, int resultCode, Intent data) {
//		if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
//			if (resultCode == RESULT_OK) {
//				Place place = PlaceAutocomplete.getPlace(this, data);
//
//				getCityAttribute(place);
//
//				Log.i(TAG, "nActivityResult RUN - Place: " + place.getName());
//			} else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
//				Status status = PlaceAutocomplete.getStatus(this, data);
//
//				Log.i(TAG, status.getStatusMessage());
//
//			} else if (resultCode == RESULT_CANCELED) {
//
//			}
//		}
//		super.onActivityResult(requestCode, resultCode, data);
//	}
//
//	private View.OnClickListener selectCity = new View.OnClickListener() {
//		@Override
//		public void onClick(View view) {
//
//			boolean newCity = true;
//			long cityId;
//			CityDao cityDao = mDataBase.mCityDao();
//			SpaceDao spaceDao = mDataBase.mSpaceDao();
//			List<String> allCitiesIdentifier = cityDao.getAllCitiesIndentifier();
//
//
//			for(String identi : allCitiesIdentifier){
//				if(identi.equals(mCityIdentifier)){
//					newCity = false;
//					Log.i(TAG, "newCity is " + newCity);
//					break;
//				}
//			}
//
//			if(newCity){
//				cityId = cityDao.insertCity(new City(mCityName,mCityIdentifier,mCityBorders,mCityCoordinates));
//
//				AddInSpaces add = new AddInSpaces();
//				add.doInBackground();
//
//				for(Space space : mSpaces){
//					space.cityId = cityId;
//				}
//
//				insertSpaceListInBase(mSpaces, spaceDao);
//
//				Log.i(TAG, "insertCity " + mCityName);
//			} else {
//				Log.i(TAG, "getCity  " + mCityName);
//				cityId = cityDao.getCity(mCityIdentifier).id;
//			}
//
//			buttonClick(cityId);
//		}
//
//	};
//
//	private void getCityAttribute(Place place){
//		mCityName = (String) place.getName();
//		mCityCoordinates = Coordinate.convertToCoordinate(place.getLatLng());
//		mCityIdentifier = (String) place.getId();
//		mCityBorders = Border.convertToBorder(place.getViewport());
//		mLatLngBounds = place.getViewport();
//	}
//
//	private Space createSpaceOutPlace(Place place){
//		String spaceName = (String) place.getName();
//		Coordinate spaceCoordinates = Coordinate.convertToCoordinate(place.getLatLng());
//		String spaceIdentifier = (String) place.getId();
//
//		return new Space(spaceCoordinates,spaceIdentifier,spaceName);
//	}
//
//	private void insertSpaceListInBase(List<Space> spaceList, SpaceDao spaceDao){
//		for (Space space : spaceList){
//			spaceDao.insertSpace(space);
//		}
//	}
//
//
//	private void getPlacesInCities(){
//		PendingResult<AutocompletePredictionBuffer> result = Places.GeoDataApi
//				.getAutocompletePredictions(mGoogleApiClient, null, mLatLngBounds, null);
//
//		AutocompletePredictionBuffer PredictionBuffer = result.await();//.await(60, TimeUnit.SECONDS);
//
//		for (AutocompletePrediction prediction: PredictionBuffer){
//			mListSpaceId.add(prediction.getPlaceId());
//		}
//
//		PredictionBuffer.release();
//
//		for(String spaceId : mListSpaceId){
//			for (int x = 0; x <6; x++) {
//				Places.GeoDataApi.getPlaceById(mGoogleApiClient, spaceId)
//						.setResultCallback(new ResultCallback<PlaceBuffer>() {
//							@Override
//							public void onResult(PlaceBuffer places) {
////								AddInSpaces add = new AddInSpaces(places);
////								add.doInBackground();
//
//							}
//						});
//			}
//		}
//
//	}
//
//	class AddInSpaces extends AsyncTask <Void, Void, Void>{
//
//		PendingResult<AutocompletePredictionBuffer> result;
//		AutocompletePredictionBuffer PredictionBuffer;
////		AutocompletePredictionBuffer PredictionBuffer;
////
////		public AddInSpaces (AutocompletePredictionBuffer PredictionBuffer){
////			this.PredictionBuffer = PredictionBuffer;
////		}
//
//
//		@Override
//		protected void onPreExecute() {
//			super.onPreExecute();
//			AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
//					.setTypeFilter(AutocompleteFilter.TYPE_FILTER_NONE)
//					.build();
//
//
//			result = Places.GeoDataApi.getAutocompletePredictions
//					(mGoogleApiClient, null, mLatLngBounds, typeFilter);
//
//		}
//
//		@Override
//		protected Void doInBackground(Void... voids) {
//
//			PredictionBuffer = result.await();
//
//			return null;
//		}
//
//		@Override
//		protected void onPostExecute(Void aVoid) {
//			super.onPostExecute(aVoid);
//
//			for (AutocompletePrediction prediction: PredictionBuffer){
//				mListSpaceId.add(prediction.getPlaceId());
//			}
//
//			PredictionBuffer.release();
//
//			for(String spaceId : mListSpaceId){
//				for (int x = 0; x <6; x++) {
//					Places.GeoDataApi.getPlaceById(mGoogleApiClient, spaceId)
//							.setResultCallback(new ResultCallback<PlaceBuffer>() {
//								@Override
//								public void onResult(PlaceBuffer places) {
//									if (places.getStatus().isSuccess() && places.getCount() > 0) {
//										final Place myPlace = places.get(0);
//										mSpaces.add(createSpaceOutPlace(myPlace));
//										Log.i(TAG, "Place found: " + myPlace.getName());
//									} else {
//										Log.e(TAG, "Place not found");
//									}
//									places.release();
//								}
//							});
//				}
//			}
//		}
//	}
//
//}