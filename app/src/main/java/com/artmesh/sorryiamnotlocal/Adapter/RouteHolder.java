package com.artmesh.sorryiamnotlocal.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.artmesh.sorryiamnotlocal.R;
import com.artmesh.sorryiamnotlocal.Objects.Route;

public class RouteHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

	private TextView mRouteName;
	private Route mRoute;

	public RouteHolder(LayoutInflater inflater, ViewGroup parent) {
		super(inflater.inflate(R.layout.route_item_model, parent, false));

		mRouteName = (TextView) itemView.findViewById(R.id.route_name);
	}

	public void bind(Route route){
		mRoute = route;
		mRouteName.setText(route.getName());

	}

	@Override
	public void onClick(View view) {

	}
}
