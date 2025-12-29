package com.example.nestedrecyclerdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {

    private List<User> userList;
    private OnItemClickListener listener;

    public HorizontalAdapter(List<User> userList, OnItemClickListener listener) {
        this.userList = userList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_horizontal, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        User user = userList.get(position);
        holder.name.setText(user.getName());
        holder.age.setText("Age: " + user.getAge());
        holder.itemView.setOnClickListener(v -> listener.onItemClick(user));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    static class HorizontalViewHolder extends RecyclerView.ViewHolder {
        TextView name, age;

        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textUserName);
            age = itemView.findViewById(R.id.textUserAge);
        }
    }
}
