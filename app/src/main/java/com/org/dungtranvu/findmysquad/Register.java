package com.org.dungtranvu.findmysquad;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;

public class Register extends ActionBarActivity {

    private EditText email;
    private EditText password;
    private EditText confirmedPassword;
    private EditText username;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = (EditText) findViewById(R.id.registerEmailEditText);
        password = (EditText) findViewById(R.id.registerPasswordEditText);
        confirmedPassword = (EditText) findViewById(R.id.registerCPasswordEditText);
        username = (EditText) findViewById(R.id.registerUsernameEditText);
        registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setEnabled(false);

        confirmedPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(email.getText().toString() != null && password.getText().toString() != null &&
                        confirmedPassword.getText().toString() != null){
                         if(confirmedPassword.getText().toString().equals(password.getText().toString())){
                                 Context context = getApplicationContext();
                                CharSequence text = "Passwords match.";
                                 int duration = Toast.LENGTH_SHORT;
                                 Toast toast = Toast.makeText(context,text,duration);
                                toast.show();
                                registerButton.setEnabled(true);
                         }
                }
                else{
                    registerButton.setEnabled(false);
                }
            }
        });
      }

    public void register(View view){
        Firebase.setAndroidContext(this);
        Firebase firebase = new Firebase("https://glaring-torch-5358.firebaseio.com/");
        final Firebase userData = firebase.child("users");
        firebase.createUser(email.getText().toString(),password.getText().toString(), new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> stringObjectMap) {
                Context context = getApplicationContext();
                String name = username.getText().toString();
                final Firebase user_name = userData.child(name);
                user_name.setValue(email.getText().toString());
                CharSequence text = "Successfully created user account with: " + email.getText().toString();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();
                goLogin();
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                Context context = getApplicationContext();
                CharSequence text = "ERROR :(";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();
            }
        });
    }

    public void goLogin(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
