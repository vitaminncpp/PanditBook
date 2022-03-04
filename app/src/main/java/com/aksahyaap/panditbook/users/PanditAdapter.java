package com.aksahyaap.panditbook.users;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aksahyaap.panditbook.R;

import java.util.ArrayList;
import java.util.List;

public class PanditAdapter extends RecyclerView.Adapter<PanditAdapter.ViewHolder> {

    List<Pandit> panditList = new ArrayList<>();
    Context context;

    public PanditAdapter(Context context){
        this.context = context;
    }
    public void setPanditList(List<Pandit>panditList){
        this.panditList = panditList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pandit_card_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pandit pandit = panditList.get(position);
        holder.panditDet(pandit);
    }

    @Override
    public int getItemCount() {
        return panditList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtView_panditName;
        TextView txtView_panditRating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtView_panditName = itemView.findViewById(R.id.txtView_panditName);
            txtView_panditRating = itemView.findViewById(R.id.txtView_panditRating);
        }

        public void panditDet(Pandit pandit){
            String panditName = pandit.getPanditName();
            float panditRating = pandit.getPanditRating();
            txtView_panditName.setText(panditName);
            txtView_panditName.setText(String.valueOf(panditRating));
        }
    }
}
