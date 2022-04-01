package com.aksahyaap.panditbook.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
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

    private NavigationView navigation;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private DrawerLayout layout;


    private User user;


    private TextView txtProfileName;
    private TextView txtProfileEmail;
    private TextView txtProfilePhone;
    private TextView txtProfileAddr;

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

//        Intent i = getIntent();
//        user = (User) i.getSerializableExtra("user");
//        Log.i("UserInfoPass", user.toString());
        username = "SKR";

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigation = (NavigationView) findViewById(R.id.navigation);
        layout = (DrawerLayout) findViewById(R.id.layout_navigation);

        toggle = new ActionBarDrawerToggle(this, layout, toolbar, R.string.open, R.string.close);
        toggle.getDrawerArrowDrawable().setColor(Color.WHITE);

        layout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
        navigation.setCheckedItem(R.id.menu_profile);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment f = null;
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        f = new ProfileFragment();
                        ((ProfileFragment)f).setUserInfo(user);
                        Toast.makeText(getApplicationContext(), "Home is selected", Toast.LENGTH_SHORT).show();
                        navigation.setCheckedItem(R.id.menu_home);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
                        break;
                    case R.id.menu_profile:
                        Bundle bundle = new Bundle();
                        bundle.putString("username", username);
                        f = new ProfileFragment();
                        Toast.makeText(getApplicationContext(), "Profile is selected", Toast.LENGTH_SHORT).show();
                        navigation.setCheckedItem(R.id.menu_profile);
                        f.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();

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