package com.artmesh.sorryiamnotlocal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

public class MainChoiceFragment extends Fragment {
	choiceClickListener mChoiceClickListener;


	public interface choiceClickListener {
		public void buttonClick(int buttonId);
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);

		try {
			mChoiceClickListener = (choiceClickListener) context;
		} catch (ClassCastException excep) {
			throw new ClassCastException(context.toString() + "  must implement choiceClickListener");
		}
	}

	private View.OnClickListener mClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			mChoiceClickListener.buttonClick(view.getId());
		}
	};

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		String[] cities = getResources().getStringArray(R.array.cities);
		View thisFragment = inflater.inflate(R.layout.fragment_choice_main, container, false);

		Button buttonMap = (Button) thisFragment.findViewById(R.id.buttonMap);
		Button buttonChoice = (Button) thisFragment.findViewById(R.id.buttonChoice);
		AutoCompleteTextView choiceCity = (AutoCompleteTextView) thisFragment.findViewById(R.id.choiceCity);

		buttonMap.setOnClickListener(mClickListener);
		buttonChoice.setOnClickListener(mClickListener);

		List<String> citiesList = Arrays.asList(cities);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(thisFragment.getContext(), android.R.layout.simple_dropdown_item_1line, citiesList);
		choiceCity.setAdapter(adapter);


		return thisFragment;
	}
}
