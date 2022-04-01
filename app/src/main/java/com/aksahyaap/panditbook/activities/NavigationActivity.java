package com.aksahyaap.panditbook.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.aksahyaap.panditbook.R;
import com.aksahyaap.panditbook.fragments.HomeFragment;
import com.aksahyaap.panditbook.fragments.ProfileFragment;
import com.aksahyaap.panditbook.fragments.SendRequestFragment;
import com.aksahyaap.panditbook.model.User;
import com.google.android.material.navigation.NavigationView;

public class NavigationActivity extends AppCompatActivity {

    Bundle bundle;
    private NavigationView navigation;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private DrawerLayout layout;
    private User user;
    private ProfileFragment profile;
    private TextView txtProfileName;
    private TextView txtProfileEmail;
    private TextView txtProfilePhone;
    private TextView txtProfileAddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        Intent i = getIntent();
        user = (User) i.getSerializableExtra("user");
        Log.i("UserInfoPass", user.toString());

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigation = (NavigationView) findViewById(R.id.navigation);
        layout = (DrawerLayout) findViewById(R.id.layout_navigation);

        toggle = new ActionBarDrawerToggle(this, layout, toolbar, R.string.open, R.string.close);
        toggle.getDrawerArrowDrawable().setColor(Color.WHITE);

        layout.addDrawerListener(toggle);
        toggle.syncState();

        bundle = new Bundle();
//                        REPLACE THIS WITH USERDATA
        bundle.putString("name", user.getName());
        bundle.putString("email", user.getEmail());
        bundle.putString("phone", user.getPhone());
        bundle.putString("addr", user.getAddress());
        profile = new ProfileFragment();
        profile.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, profile).commit();
        navigation.setCheckedItem(R.id.menu_profile);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment f = null;
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        f = new HomeFragment();
                        Toast.makeText(getApplicationContext(), "Home is selected", Toast.LENGTH_SHORT).show();
                        navigation.setCheckedItem(R.id.menu_home);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
                        break;
                    case R.id.menu_profile:

                        Toast.makeText(getApplicationContext(), "Profile is selected", Toast.LENGTH_SHORT).show();
                        navigation.setCheckedItem(R.id.menu_profile);
                        profile.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, profile).commit();

//                        Log.d("ProfileFragment",txtProfileName.getText().toString());
                        break;
                    case R.id.menu_send:
                        f = new SendRequestFragment();
                        Toast.makeText(getApplicationContext(), "Send Request is selected", Toast.LENGTH_SHORT).show();
                        navigation.setCheckedItem(R.id.menu_send);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Fuck You Asshole", Toast.LENGTH_SHORT).show();
                        f = null;
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
                        break;
                }

                layout.closeDrawer(GravityCompat.START);

                return true;
            }
        });


    }
}