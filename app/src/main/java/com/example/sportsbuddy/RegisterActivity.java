package com.example.sportsbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText inputEmail,inputPassword;
    private Button btnSignIn,btnSignUp;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );
        auth=FirebaseAuth.getInstance();
        btnSignIn= findViewById( R.id.signup );
        btnSignUp=findViewById( R.id.signin );
        inputEmail= findViewById( R.id.email1 );
        inputPassword= findViewById( R.id.password1 );
        progressBar=findViewById( R.id.progressBar );
        btnSignIn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
        btnSignUp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=inputEmail.getText().toString();
                String password=inputPassword.getText().toString();
                if(TextUtils.isEmpty( email )){
                    Toast.makeText( getApplicationContext(),"Enter e-mail address",Toast.LENGTH_SHORT ).show();
                    return;
                }
                if(TextUtils.isEmpty( password )){
                    Toast.makeText( getApplicationContext(),"Enter a password",Toast.LENGTH_SHORT ).show();
                    return;
                }
                if(password.length()<5){
                    Toast.makeText( getApplicationContext(),"Choose a new password",Toast.LENGTH_SHORT ).show();
                    return;
                }
                progressBar.setVisibility( View.VISIBLE );
                auth.createUserWithEmailAndPassword( email,password ).addOnCompleteListener( RegisterActivity.this, new OnCompleteListener<AuthResult> () {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText( RegisterActivity.this,"createUserWithEmail:onComplete:"+task.isSuccessful(),Toast.LENGTH_SHORT ).show();
                        progressBar.setVisibility( View.GONE );
                        if(!task.isSuccessful()){
                            Toast.makeText( RegisterActivity.this,"Authentification Failed"+task.getException(),Toast.LENGTH_SHORT ).show();
                        }
                        else
                        {
                            startActivity( (new Intent ( RegisterActivity.this ,MainActivity.class)) );
                            finish();
                        }

                    }
                } );

            }
        } );



    }
}
