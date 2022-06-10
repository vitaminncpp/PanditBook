package com.aksahyaap.panditbook.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aksahyaap.panditbook.R;
import com.aksahyaap.panditbook.activities.MainActivity;
import com.aksahyaap.panditbook.activities.NavigationActivity;
import com.aksahyaap.panditbook.adapters.PanditAdapter;
import com.aksahyaap.panditbook.model.Search;
import com.aksahyaap.panditbook.model.User;
import com.aksahyaap.panditbook.network.APIInterface;
import com.aksahyaap.panditbook.network.RetrofitClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match


    RecyclerView recyclerHomePandits;
    Button btnHomeLoad;
    Search search;
    List<User> panditList;
    PanditAdapter adapter;
    APIInterface api= RetrofitClient.getInstance();
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api= RetrofitClient.getInstance();
        search=new Search();
        search.setPageno(0);
        search.setPageSize(2);
    }



    @SuppressLint("NotifyDataSetChanged")
    private void init() {
        panditList = new ArrayList<User>();
        adapter = new PanditAdapter(requireContext());
        recyclerHomePandits.setAdapter(adapter);

        Call<Map<String, Object>> call = api.getAllPandits(search);
        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                //dialog.dismiss();

                Log.i("RegistrationResponse", response.body().toString());
                user = response.body();
                Log.d("LoginTrack", "Login Succeeds:" + response.body().toString());
                Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, NavigationActivity.class);
                i.putExtra("user", user);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                //dialog.dismiss();
                Log.d("LoginTrack", "Server is not reachable:" + t);
            }
        });

        adapter.setUserList(panditList);
        adapter.notifyDataSetChanged();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerHomePandits = view.findViewById(R.id.recyclerHomePandits);
        recyclerHomePandits.setLayoutManager(new LinearLayoutManager(requireContext()));
        btnHomeLoad=view.findViewById(R.id.btnHomeLoad);
        recyclerHomePandits.setHasFixedSize(true);
        init();

        return view;
    }
}