package com.aksahyaap.panditbook.users;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aksahyaap.panditbook.R;

import java.util.ArrayList;
import java.util.List;

public class PanditsAdapter extends RecyclerView.Adapter<PanditsAdapter.ViewHolder> {

    List<Pandit> panditList = new ArrayList<>();
    Context context;

    public PanditsAdapter(Context context){
        this.context = context;
    }
    public void setPanditsList(List<Pandit>panditList){
        this.panditList = panditList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pandit_card_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return panditList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
