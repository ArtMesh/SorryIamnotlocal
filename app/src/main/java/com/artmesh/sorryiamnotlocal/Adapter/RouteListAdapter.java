package com.artmesh.sorryiamnotlocal.Adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.artmesh.sorryiamnotlocal.R;
import com.artmesh.sorryiamnotlocal.Objects.Route;

import java.util.List;

public class RouteListAdapter extends Adapter<RouteHolder> {

	private List<Route> mRouteList;

	public RouteListAdapter(List<Route> RouteList) {
		this.mRouteList = RouteList;
	}

	@Override
	public RouteHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.route_item_model, parent, false);

		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

		RouteHolder holder = new RouteHolder(layoutInflater, parent);
		return holder;
	}

	@Override
	public void onBindViewHolder(RouteHolder holder, int position) {
		Route route = mRouteList.get(position);
		holder.bind(route);
	}

	@Override
	public int getItemCount() {
		return  mRouteList.size();
	}
}
