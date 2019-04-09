package com.example.datacollection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameText,emailText,passText;
    private Button signup,login;
    String name, email, pass;

    public void instantiate(){
        nameText = findViewById(R.id.name);
        emailText = findViewById(R.id.email);
        passText = findViewById(R.id.pass);
        signup = findViewById(R.id.sup);
        login = findViewById(R.id.log);
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
        takeValue();
    }

    public void login(View view) {
        Toast.makeText(this, "login", Toast.LENGTH_SHORT).show();
    }

    public void signup(View view) {
        Toast.makeText(this,"signup",Toast.LENGTH_SHORT).show();
    }
}
