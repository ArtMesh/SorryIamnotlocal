package com.artmesh.sorryiamnotlocal.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;

public abstract class AbstractListAdapter  extends Adapter<AbstractListAdapter.AbstractViewHolder>{

	public abstract class AbstractViewHolder extends RecyclerView.ViewHolder{

		public AbstractViewHolder(View itemView) {
			super(itemView);
		}
	}
}
