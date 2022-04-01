package com.aksahyaap.panditbook.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.aksahyaap.panditbook.R;
import com.aksahyaap.panditbook.model.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters



    private TextView txtProfileName;
    private TextView txtProfileEmail;
    private TextView txtProfilePhone;
    private TextView txtProfileAddr;


    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View view= inflater.inflate(R.layout.fragment_profile, container, false);

        txtProfileName = view.findViewById(R.id.txtProfileName);
        txtProfileEmail = view.findViewById(R.id.txtProfileEmail);
        txtProfilePhone = view.findViewById(R.id.txtProfilePhone);
        txtProfileAddr = view.findViewById(R.id.txtProfileAddr);

        if(getArguments() != null){
            setUserInfo(getArguments().getString("username"),
                getArguments().getString("phno"),
                getArguments().getString("email"),
                getArguments().getString("add")
            );
        }



        return view;
    }

    public void setUserInfo(String username, String phno, String email, String add) {
        txtProfileAddr.setText(add);
        txtProfileName.setText(username);
        txtProfileEmail.setText(email);
        txtProfilePhone.setText(phno);
    }

}