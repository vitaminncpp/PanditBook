package com.aksahyaap.panditbook.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aksahyaap.panditbook.R;
import com.aksahyaap.panditbook.users.Pandit;
import com.aksahyaap.panditbook.users.PanditAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    RecyclerView recyclerView_showPandits;
    List<Pandit> panditList;
    PanditAdapter panditAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void init(){
        panditList = new ArrayList<>();
        panditAdapter = new PanditAdapter(requireContext());
        recyclerView_showPandits.setAdapter(panditAdapter);
        panditList.add(new Pandit("Ram ji", 2));
        panditList.add(new Pandit("Lakhan da", 5));
        panditList.add(new Pandit("Angrezi Pandit", 2));
        panditList.add(new Pandit("Ji Ji Maharaj", 4));
        panditList.add(new Pandit("Pandit Hai Hum", 1));

        panditAdapter.setPanditList(panditList);
        panditAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        recyclerView_showPandits = view.findViewById(R.id.recyclerView_showPandits);
        recyclerView_showPandits.setLayoutManager(new LinearLayoutManager(requireContext()));

        recyclerView_showPandits.setHasFixedSize(true);
        init();

        return view;
    }
}