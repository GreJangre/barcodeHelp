package com.example.jangre.barcodehelp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static com.example.jangre.barcodehelp.DeserializeModel.CHILD;
import static com.example.jangre.barcodehelp.DeserializeModel.PARENT;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FoodModel> mList;

    public RecyclerAdapter(List<FoodModel> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case PARENT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_header, parent, false);
                return new ParentViewHolder(view);
            case CHILD:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
                return new ChildViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FoodModel object = mList.get(position);
        if (object != null) {
            switch (object.getmType()) {
                case PARENT:
                    ((ParentViewHolder) holder).mTitle.setText(object.getmFood());
                    break;
                case CHILD:
                    ((ChildViewHolder) holder).mFood.setText(object.getmFood());
                    ((ChildViewHolder) holder).mDate.setText(String.format("유통기한: %s", object.getmDate()));
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mList != null) {
            FoodModel object = mList.get(position);
            if (object != null) {
                return object.getmType();
            }
        }
        return 0;
    }

    public static class ParentViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;

        ParentViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.titleTextView);
        }
    }

    public static class ChildViewHolder extends RecyclerView.ViewHolder {
        private TextView mFood, mDate;

        ChildViewHolder(View itemView) {
            super(itemView);
            mFood = itemView.findViewById(R.id.txtFood);
            mDate = itemView.findViewById(R.id.txtDate);
        }
    }
}