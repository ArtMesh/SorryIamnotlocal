package com.artmesh.sorryiamnotlocal.list_adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.artmesh.sorryiamnotlocal.R;
import com.artmesh.sorryiamnotlocal.database.entities.Route;

import java.util.List;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.CityViewHolder> {

	private List<Route> mRouteList;
	private CityListAdapter.OnListClickListener mOnListClickListener;

	@Override
	public void onAttachedToRecyclerView(RecyclerView recyclerView) {
		super.onAttachedToRecyclerView(recyclerView);
	}

	public interface OnListClickListener {
		void onListClick(Route route);
	}

	public CityListAdapter(List<Route> RouteList, CityListAdapter.OnListClickListener onListClickListener) {
		this.mRouteList = RouteList;
		this.mOnListClickListener = onListClickListener;
	}

	@Override
	public CityListAdapter.CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View itemView = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.route_item_model, parent, false);

		CityListAdapter.CityViewHolder mHolder = new CityListAdapter.CityViewHolder(itemView);
		return mHolder;
	}

	@Override
	public void onBindViewHolder(CityListAdapter.CityViewHolder holder, int position) {
		Route route = mRouteList.get(position);
		holder.bind(route);
	}

	@Override
	public int getItemCount() {
		return mRouteList.size();
	}

	class CityViewHolder extends RecyclerView.ViewHolder{
		private TextView mRouteName;

		public CityViewHolder(View itemView) {
			super(itemView);
			mRouteName = (TextView) itemView.findViewById(R.id.place_name);

			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Route route = mRouteList.get(getLayoutPosition());
					mOnListClickListener.onListClick(route);
				}
			});
		}

		public void bind(Route route){
			mRouteName.setText(route.name);
		}
	}
}
