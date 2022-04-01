package com.aksahyaap.panditbook.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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



    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
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
        panditList.add(new Pandit("Ram ji", 2,"I'm a good pandit", "Mumbai,Maharastra"));
        panditList.add(new Pandit("Lakhan da", 5,"I'm a good pandit too", "Bhopal,MP"));
        panditList.add(new Pandit("Angrezi Pandit", 2,"high rated pandit for shadi and sagai", "Ahmedabar,Gujarat"));
        panditList.add(new Pandit("Ji Ji Maharaj", 4,"Humko bas nyochhavar se matlab hai. Jidhar jaada paisa udhar hum", "Mumbai,Maharastra"));
        panditList.add(new Pandit("Engineer Pandit", 1,"Btech Pandit", "Delhi,Delhi"));

        panditAdapter.setPanditList(panditList);
        panditAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView_showPandits = view.findViewById(R.id.recyclerView_showPandits);
        recyclerView_showPandits.setLayoutManager(new LinearLayoutManager(requireContext()));

        recyclerView_showPandits.setHasFixedSize(true);
        init();

        return view;
    }
}