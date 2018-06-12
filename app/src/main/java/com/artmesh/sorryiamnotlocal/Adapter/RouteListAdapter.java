package com.artmesh.sorryiamnotlocal.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.artmesh.sorryiamnotlocal.R;
import com.artmesh.sorryiamnotlocal.objects.Route;

import java.util.List;

public class RouteListAdapter extends Adapter<RouteListAdapter.RouteViewHolder> {

	private List<Route> mRouteList;
	private OnListClickListener mOnListClickListener;

	@Override
	public void onAttachedToRecyclerView(RecyclerView recyclerView) {
		super.onAttachedToRecyclerView(recyclerView);
	}

	public interface OnListClickListener {
		void onListClick(Route route);
	}


	public RouteListAdapter(List<Route> RouteList, OnListClickListener onListClickListener) {
		this.mRouteList = RouteList;
		this.mOnListClickListener = onListClickListener;
	}

	@Override
	public RouteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View itemView = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.route_item_model, parent, false);

		RouteViewHolder mHolder = new RouteViewHolder(itemView);
		return mHolder;
	}

	@Override
	public void onBindViewHolder(RouteViewHolder holder, int position) {
		Route route = mRouteList.get(position);
		holder.bind(route);
	}

	@Override
	public int getItemCount() {
		return  mRouteList.size();
	}

	class RouteViewHolder extends RecyclerView.ViewHolder{
		private TextView mRouteName;

		public RouteViewHolder(View itemView) {
			super(itemView);
			mRouteName = (TextView) itemView.findViewById(R.id.route_name);

			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Route route = mRouteList.get(getLayoutPosition());
					mOnListClickListener.onListClick(route);
				}
			});
		}

		public void bind(Route route){
			mRouteName.setText(route.getName());
		}
	}






}
