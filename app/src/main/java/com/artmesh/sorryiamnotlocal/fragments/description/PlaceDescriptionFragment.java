package com.artmesh.sorryiamnotlocal.fragments.description;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artmesh.sorryiamnotlocal.R;

public class PlaceDescriptionFragment extends Fragment {
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View thisFragment = inflater.inflate(R.layout.place_description_fragment, container, false);
		return thisFragment;
	}
}
