package com.example.vaccineapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ItemClickListener clickListener;
    private final VaccineModel[] listData;

    public CustomAdapter(VaccineModel[] listData) {
        this.listData = listData;
    }

    public void setOnClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imgVaccine;
        private TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgVaccine = itemView.findViewById(R.id.imgVaccine);
            this.tvTitle = itemView.findViewById(R.id.tvTitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onClick(v, getAdapterPosition());
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final VaccineModel dataModel = listData[position];
        holder.tvTitle.setText(dataModel.getTitle());
        holder.imgVaccine.setImageResource(dataModel.getImageResource());
    }


    @Override
    public int getItemCount() {
        return listData.length;
    }
}
