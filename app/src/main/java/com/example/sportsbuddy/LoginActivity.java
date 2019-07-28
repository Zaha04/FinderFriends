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

public class LoginActivity extends AppCompatActivity {
    private EditText inputEmail,inputPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button login;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );
        auth=FirebaseAuth.getInstance ();
        if(auth.getCurrentUser ()!=null){
            startActivity ( new Intent ( LoginActivity.this,MainActivity.class ) );
            finish ();
        }
        inputEmail=(EditText)findViewById ( R.id.email1 );
        inputPassword=(EditText)findViewById ( R.id.password1);
        progressBar=(ProgressBar)findViewById ( R.id.progressBar2 );
                login=(Button)findViewById ( R.id.login );
        auth=FirebaseAuth.getInstance ();
        login.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                String email=inputEmail.getText ().toString ();
                final String password=inputPassword.getText ().toString ();
                if(TextUtils.isEmpty ( email )){
                    Toast.makeText ( getApplicationContext (),"Enter an e-mail",Toast.LENGTH_SHORT ).show ();
                    return;
                }
                if(TextUtils.isEmpty ( password )){
                    Toast.makeText ( getApplicationContext (),"Enter a password",Toast.LENGTH_SHORT ).show ();
                    return;
                }
                progressBar.setVisibility ( View.VISIBLE );
                auth.signInWithEmailAndPassword ( email,password ).addOnCompleteListener ( LoginActivity.this, new OnCompleteListener<AuthResult> () {
                    @Override
                    public void onComplete (@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility ( View.GONE );
                        if (!task.isSuccessful()) {
                            // there was an error
                            if (password.length() < 6) {
                                inputPassword.setError(getString(R.string.minimum_paswword));
                            } else {
                                Toast.makeText(LoginActivity.this, getString(R.string.auth_error), Toast.LENGTH_LONG).show();
                            }
                        } else {

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }
        } );
    }
}
