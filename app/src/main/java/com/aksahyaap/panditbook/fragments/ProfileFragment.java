package com.aksahyaap.panditbook.fragments;

import android.os.Bundle;
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
    private User user;


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
    public static ProfileFragment newInstance(User user) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setUserInfo(user);
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

        txtProfileName = container.findViewById(R.id.txtProfileName);
        txtProfileEmail = container.findViewById(R.id.txtProfileEmail);
        txtProfilePhone = container.findViewById(R.id.txtProfilePhone);
        txtProfileAddr = container.findViewById(R.id.txtProfileAddr);

        txtProfileAddr.setText(user.getAddress());
        txtProfileName.setText(user.getName());
        txtProfileEmail.setText(user.getEmail());
        txtProfilePhone.setText(user.getPhone());


        return view;
    }

    public void setUserInfo(User user) {
        this.user = user;
    }

}