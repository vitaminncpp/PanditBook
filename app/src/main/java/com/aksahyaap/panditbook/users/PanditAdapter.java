package com.aksahyaap.panditbook.users;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtView_panditName;
        TextView txtView_panditRating;
        TextView txtView_panditLocation;
        TextView txtView_panditBio;
        Button btn_panditHire;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtView_panditName = itemView.findViewById(R.id.txtView_panditName);
            txtView_panditRating = itemView.findViewById(R.id.txtView_panditRating);
            txtView_panditLocation = itemView.findViewById(R.id.txtView_panditLocation);
            txtView_panditBio = itemView.findViewById(R.id.txtView_panditBio);
            btn_panditHire = itemView.findViewById(R.id.btn_panditHire);

            btn_panditHire.setOnClickListener(view -> {
                Toast.makeText(view.getContext(), "Btn Clicked "+txtView_panditName.getText().toString(), Toast.LENGTH_SHORT).show();
                //do something here on click
            });
        }

        @SuppressLint("SetTextI18n")
        public void panditDet(Pandit pandit){
            String panditName = pandit.getPanditName();
            float panditRating = pandit.getPanditRating();
            String panditBio = pandit.getPanditBio();
            String panditLoc = pandit.getPanditLoc();

            txtView_panditName.setText(panditName);
            txtView_panditRating.setText(panditRating + "stars");
            txtView_panditBio.setText(String.valueOf(panditBio));
            txtView_panditLocation.setText(String.valueOf(panditLoc));
        }
    }
}
