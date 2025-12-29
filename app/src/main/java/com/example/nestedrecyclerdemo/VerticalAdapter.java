package com.example.nestedrecyclerdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder> {

    private Context context;
    private List<List<User>> dataList;
    private OnItemClickListener listener;

    public VerticalAdapter(Context context, List<List<User>> dataList, OnItemClickListener listener) {
        this.context = context;
        this.dataList = dataList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_vertical, parent, false);
        return new VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {
        holder.textTitle.setText("Group " + (position + 1));

        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(dataList.get(position), listener);
        holder.recyclerHorizontal.setLayoutManager(
                new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerHorizontal.setAdapter(horizontalAdapter);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class VerticalViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle;
        RecyclerView recyclerHorizontal;

        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            recyclerHorizontal = itemView.findViewById(R.id.recyclerHorizontal);
        }
    }
}
