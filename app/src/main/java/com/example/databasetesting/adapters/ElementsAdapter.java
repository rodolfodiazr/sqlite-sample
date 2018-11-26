package com.example.databasetesting.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.databasetesting.R;

/**
 * Created by rdiaz on 11/26/18.
 */
public class ElementsAdapter extends RecyclerView.Adapter {

	private Context mContext;

	public ElementsAdapter(Context context) {
		mContext = context;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.item_list, parent, false);
		RecyclerView.ViewHolder viewHolder = new ElementViewHolder(view);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		((ElementViewHolder) holder).mName.setText("Sample");
	}

	@Override
	public int getItemCount() {
		return 0;
	}

	private class ElementViewHolder extends RecyclerView.ViewHolder {

		private final TextView mName;

		public ElementViewHolder(View view) {
			super(view);
			mName = view.findViewById(R.id.elementNameTextView);
		}
	}
}
