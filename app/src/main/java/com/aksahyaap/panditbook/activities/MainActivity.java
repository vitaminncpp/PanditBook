package com.aksahyaap.panditbook.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aksahyaap.panditbook.R;
import com.aksahyaap.panditbook.model.User;
import com.aksahyaap.panditbook.network.APIInterface;
import com.aksahyaap.panditbook.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText txtEmail;
    private EditText txtPass;

    private Button btnSignup;
    private Button btnLogin;
    private Button btnForgot;

    private ProgressDialog dialog;
    private APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface = RetrofitClient.getInstance();

        dialog = new ProgressDialog(getApplicationContext());

        txtEmail = findViewById(R.id.txtEmailLogin);
        txtPass = findViewById(R.id.txtPassLogin);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignUp);
        btnForgot = findViewById(R.id.btnForgot);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (validate()) {
                    //TODO Send Login Request
                    User login = new User();
                    login.setEmail(txtEmail.getText().toString());
                    login.setpHash(txtPass.getText().toString());
                    User user = login(login);
                    if (user != null) {
                        //TODO User Logged in successfully
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please Enter valid input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validate() {
        boolean isValid = true;

        if (txtEmail.getText().toString().isEmpty()) {

            txtEmail.setBackground(getDrawable((R.drawable.bg_text_error)));
            isValid = false;

        } else {
            txtEmail.setBackground(getDrawable(R.drawable.bg_text));
        }

        if (txtPass.getText().toString().isEmpty()) {

            txtPass.setBackground(getDrawable((R.drawable.bg_text_error)));
            isValid = false;

        } else {
            txtPass.setBackground(getDrawable(R.drawable.bg_text));
        }

        return isValid;

    }

    private User login(User login) {

        dialog.setMessage("Sending Data to Server ...");
        dialog.setCancelable(false);
       // dialog.show();

        Call<User> call = apiInterface.login(login);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
               // dialog.dismiss();
                if (response.isSuccessful()) {
                    Log.i("RegistrationResponse", response.body().toString());

                    Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                dialog.dismiss();
            }
        });
        return null;
    }

}