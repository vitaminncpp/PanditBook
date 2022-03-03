package com.aksahyaap.panditbook.activities;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aksahyaap.panditbook.R;
import com.aksahyaap.panditbook.models.User;
import com.aksahyaap.panditbook.network.APIInterface;
import com.aksahyaap.panditbook.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private EditText txtName;
    private EditText txtEmail;
    private EditText txtPass;
    private EditText txtAddress;
    private EditText txtPhone;
    private EditText txtBDate;


    private RadioButton rdoUsr;
    private RadioButton rdoPdt;
    private TextView lblChoice;
    private RadioGroup rdoGrp;
    private RadioButton radioButton=null;
    private Button btnSignUp;


    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        this.progressDialog=new ProgressDialog(this)  ;

        this.txtName = findViewById(R.id.txtName);
        this.txtEmail = findViewById(R.id.txtEmail);
        this.txtBDate = findViewById(R.id.txtBDate);
        this.txtAddress = findViewById(R.id.txtAddress);
        this.txtPhone = findViewById(R.id.txtPhone);
        this.txtPass = findViewById(R.id.txtPass);


        this.rdoUsr = findViewById(R.id.rdoUsr);
        this.rdoPdt = findViewById(R.id.rdoPdt);

        this.lblChoice = findViewById(R.id.lblChoice);
        this.rdoGrp = findViewById(R.id.rdoGrp);


        this.btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.i("btnSignUp", "Clicked");
                boolean isValid = validate();
                if (isValid) {
                    sendData();
                }else{
                    Toast.makeText(getApplicationContext(), "Please Fill All Required information", Toast.LENGTH_SHORT).show();
                }
            }
        });


        rdoGrp.clearCheck();


                Log.i("textProperty", "Text Element : " + txtName);
    }


    private void sendData(){
        progressDialog.setMessage("Sending Data to Server ...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        APIInterface apiInterface = RetrofitClient.getRetrofit().create(APIInterface.class);
        int checked=rdoGrp.getCheckedRadioButtonId();
        int uType;
        if(((RadioButton)findViewById(checked)).getText().toString().equals("Pandit")){
            uType=0;
        }else{
            uType=1;
        }
        User user=new User(
                this.txtName.getText().toString(),
                this.txtEmail.getText().toString(),
                uType,
                this.txtBDate.getText().toString(),
                Long.parseLong(this.txtPhone.getText().toString()),
                this.txtAddress.getText().toString(),
                this.txtPass.getText().toString()
        );

        Call<String> call=apiInterface.postData(user);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                progressDialog.dismiss();
                if(response.isSuccessful()){
                    Toast.makeText(SignUpActivity.this, response.body(),Toast.LENGTH_SHORT);
                }else {
                    Toast.makeText(SignUpActivity.this,response.body(),Toast.LENGTH_SHORT);

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
    }

    private boolean validate() {
        boolean isValid = true;
        if (txtName.getText().toString().isEmpty()) {

            txtName.setBackground(getDrawable(R.drawable.bg_text_error));
            isValid = false;
        } else {
            txtName.setBackground(getDrawable(R.drawable.bg_text));
        }


        if (txtPass.getText().toString().isEmpty()) {

            txtPass.setBackground(getDrawable((R.drawable.bg_text_error)));
            isValid = false;

        } else {
            txtPass.setBackground(getDrawable(R.drawable.bg_text));
        }


        if (txtPhone.getText().toString().isEmpty()) {

            txtPhone.setBackground(getDrawable((R.drawable.bg_text_error)));

        } else {
            txtPhone.setBackground(getDrawable(R.drawable.bg_text));
        }

        if (txtEmail.getText().toString().isEmpty()) {

            txtEmail.setBackground(getDrawable((R.drawable.bg_text_error)));
            isValid = false;

        } else {
            txtEmail.setBackground(getDrawable(R.drawable.bg_text));
        }

        if (txtAddress.getText().toString().isEmpty()) {

            txtAddress.setBackground(getDrawable(R.drawable.bg_text_error));
            isValid = false;
        } else {
            txtAddress.setBackground(getDrawable(R.drawable.bg_text));
        }

        if (txtBDate.getText().toString().isEmpty()) {
            txtBDate.setBackground(getDrawable(R.drawable.bg_text_error));
            isValid = false;
        } else {
            txtBDate.setBackground(getDrawable(R.drawable.bg_text));
        }

        if (this.radioButton==null) {
            this.lblChoice.setBackground(getDrawable((R.drawable.bg_text_error)));
            isValid = false;
        } else {
            lblChoice.setBackground(getDrawable((R.drawable.bg_text)));
        }
        return isValid;
    }

    public void cbuttonChecked(View v) {
        radioButton=null;
        int selected= rdoGrp.getCheckedRadioButtonId();

            this.radioButton=findViewById(selected);


    }
}