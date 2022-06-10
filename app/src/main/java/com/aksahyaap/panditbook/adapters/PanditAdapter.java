package com.aksahyaap.panditbook.adapters;

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
import com.aksahyaap.panditbook.model.User;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PanditAdapter extends RecyclerView.Adapter<PanditAdapter.ViewHolder> {

    List<User> panditList = new ArrayList<User>();
    Context context;

    public PanditAdapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<User> panditList) {
        this.panditList = panditList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pandit_card_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User pandit = panditList.get(position);
        holder.panditDet(pandit);
    }

    @Override
    public int getItemCount() {
        return panditList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtHomeName;
        TextView txtHomeAddr;
        TextView txtHomeEmail;
        TextView txtHomeDesc;
        TextView txtHomePhone;
        Button btnHomeHire;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHomeName = itemView.findViewById(R.id.txtHomeName);
            txtHomeAddr = itemView.findViewById(R.id.txtHomeAddr);
            txtHomeEmail = itemView.findViewById(R.id.txtHomeEmail);
            txtHomeDesc = itemView.findViewById(R.id.txtHomeDesc);
            txtHomePhone=itemView.findViewById(R.id.txtHomePhone);
            btnHomeHire = itemView.findViewById(R.id.btnHomeHire);

            btnHomeHire.setOnClickListener(view -> {
                Toast.makeText(view.getContext(), "Btn Clicked " + txtHomeName.getText().toString(), Toast.LENGTH_SHORT).show();
                //do something here on click
            });
        }

        @SuppressLint("SetTextI18n")
        public void panditDet(User pandit) {


            txtHomeName.setText(pandit.getName());
            txtHomeAddr.setText(pandit.getAddress());
            txtHomeDesc.setText(pandit.getDescription());
            txtHomeEmail.setText(pandit.getEmail());
            txtHomePhone.setText(pandit.getPhone());
        }
    }
}
