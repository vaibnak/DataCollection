package com.example.datacollection;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText nameText,emailText,passText;
    private Button regadmin,reguser;
    String name, email, pass;
    FirebaseAuth mAuth;


    public void instantiate(){

        nameText = findViewById(R.id.name);
        emailText = findViewById(R.id.email);
        passText = findViewById(R.id.pass);
        regadmin = findViewById(R.id.sup);
        reguser = findViewById(R.id.log);
        mAuth = FirebaseAuth.getInstance();

    }
    public void takeValue(){
        name = nameText.getText().toString();
        email = emailText.getText().toString();
        pass = passText.getText().toString();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instantiate();
    }

    public void login(final String role) {
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(MainActivity.this, "login done", Toast.LENGTH_SHORT).show();
                            if(role == "user"){

                            }else{

                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            signup(role);
                        }
                    }
                });
    }

    public void signup(final String role) {
        mAuth = FirebaseAuth.getInstance();
        takeValue();
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "signup done", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            if(role == "user"){

                            }else{

                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void reguser(View view){
        takeValue();
        login("user");

    }
    public void regadmin(View view){
        takeValue();
        login("admin");

    }

}
