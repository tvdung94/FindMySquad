package com.org.dungtranvu.findmysquad;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;

public class Login extends ActionBarActivity {

    Firebase firebase;
    private EditText email;
    private EditText password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.loginEmail);
        password = (EditText) findViewById(R.id.loginPassword);
        loginButton = (Button) findViewById(R.id.loginButton);
     }

     public void login(View view){
         Firebase.setAndroidContext(this);
         firebase = new Firebase("https://glaring-torch-5358.firebaseio.com/");
         firebase.authWithPassword(email.getText().toString(),password.getText().toString(),new Firebase.AuthResultHandler() {
             @Override
             public void onAuthenticated(AuthData authData) {
                  // Authentication just completed successfully :)
                 //Log.e("Dung","User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
//                 firebase.child("users").child(authData.getUid()).setValue(email.getText().toString());
//                 firebase.child("users").child(authData.getUid()).child("password").setValue(password.getText().toString());
                 goMainActivity();
             }

             @Override
             public void onAuthenticationError(FirebaseError firebaseError) {
                 Context context = getApplicationContext();
                 CharSequence text = "Login error! Correct your email/password combo!";
                 int duration = Toast.LENGTH_SHORT;
                 Toast toast = Toast.makeText(context,text,duration);
                 toast.show();
             }
         });
     }

    public void goRegister(View view){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    public void goMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
