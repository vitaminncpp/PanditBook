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


    private TextView txtProfileName;
    private TextView txtProfileEmail;
    private TextView txtProfilePhone;
    private TextView txtProfileAddr;

    private User user;

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
    public void onCreate(Bundle hPrev) {
        super.onCreate(hPrev);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        txtProfileName = view.findViewById(R.id.txtProfileName);
        txtProfileEmail = view.findViewById(R.id.txtProfileEmail);
        txtProfilePhone = view.findViewById(R.id.txtProfilePhone);
        txtProfileAddr = view.findViewById(R.id.txtProfileAddr);

        if (getArguments() != null) {

            user = new User();
            user.setName(getArguments().getString("name"));
            user.setEmail(getArguments().getString("email"));
            user.setPhone(getArguments().getString("phone"));
            user.setAddress(getArguments().getString("addr"));
        }
        txtProfileName.setText(user.getName());
        txtProfileAddr.setText(user.getAddress());
        txtProfileEmail.setText(user.getEmail());
        txtProfilePhone.setText(user.getPhone());


        return view;
    }

}